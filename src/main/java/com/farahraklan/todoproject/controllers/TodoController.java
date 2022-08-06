package com.farahraklan.todoproject.controllers;

import com.farahraklan.todoproject.entities.Todo;
import com.farahraklan.todoproject.entities.User;
import com.farahraklan.todoproject.repositories.TodoRepository;
import com.farahraklan.todoproject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class TodoController {

    public final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserController userController;

    User currentUser;

    Todo currentTodo;

    @GetMapping("/{userId}/list")
    @ResponseBody
    public List<Todo> findAllByUserId(@PathVariable("userId") Long userId) {
        logger.info("Listing all the Todo tasks");
        currentUser = userController.getCurrentUser();
        if(currentUser.getUserId() == userId){
            return todoRepository.findAllByUserId(userId);
        }else {
            return null;
        }
    }

    @PostMapping("/{userId}/add")
    public Todo add(@PathVariable("userId") Long userId, @Valid @NotNull @RequestBody Todo todo){
        logger.info("Adding a new task");
        currentUser = userController.getCurrentUser();
        if(currentUser == null){
            return null;
        }else {
            if (currentUser.getUserId() == userId) {
                todo.setUserId(userId);
                return todoRepository.save(todo);
            } else {
                return null;
            }
        }
    }

    @PutMapping("/{userId}/update/{todoId}")
    public Todo update(@PathVariable("userId") Long userId, @PathVariable("todoId") Long todoId,
                       @Valid @NotNull @RequestBody Todo todo){
        logger.info("Updating a task");
        currentUser = userController.getCurrentUser();
        Optional<Todo> getTodo = todoRepository.findById(todoId);
        currentTodo = getTodo.get();
        if(currentUser == null){
            return null;
        }else{
            if(getTodo.isEmpty()){
                return null;
            }else{
                if(currentUser.getUserId() == userId){
                    if (todoRepository.checkTodobyUserIdAndTodoId(userId, todoId).size() != 0) {
                        todo.setTodoId(todoId);
                        todo.setUserId(userId);
                        return todoRepository.save(todo);
                    }else{
                        return null;
                    }
                }else{
                    return null;
                }
            }
        }
    }

    @DeleteMapping("/{userId}/delete/{todoId}")
    public void delete(@PathVariable("userId") Long userId, @PathVariable("todoId") Long todoId) {
        logger.info("Deleting a task");
        currentUser = userController.getCurrentUser();
        Optional<Todo> getTodo = todoRepository.findById(todoId);
        currentTodo = getTodo.get();
        if(currentUser == null){
        }else {
            if (getTodo.isEmpty()) {
            }else{
                if(currentUser.getUserId() == userId){
                    if (todoRepository.checkTodobyUserIdAndTodoId(userId, todoId).size() != 0) {
                        todoRepository.deleteById(todoId);
                    }
                }
            }
        }
    }

}
