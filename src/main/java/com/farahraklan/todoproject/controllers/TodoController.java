package com.farahraklan.todoproject.controllers;

import com.farahraklan.todoproject.entities.Todo;
import com.farahraklan.todoproject.repositories.TodoRepository;
import com.farahraklan.todoproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{userId}/list")
    public List<Todo> findAllByUserId(@PathVariable("userId") Long userId) {
        return todoRepository.findAllByUserId(userId);
    }

    @PostMapping("/{userId}/add")
    public Todo add(@PathVariable("userId") Long userId, @Valid @NotNull @RequestBody Todo todo){
        todo.setUserId(userId);
        return todoRepository.save(todo);
    }

    @PutMapping("/{userId}/update/{todoId}")
    public Todo update(@PathVariable("userId") Long userId, @PathVariable("todoId") Long todoId, @Valid @NotNull @RequestBody Todo todo){
        if (todoRepository.checkTodobyUserIdAndTodoId(userId, todoId).size() != 0) {
            todo.setTodoId(todoId);
            todo.setUserId(userId);
            return todoRepository.save(todo);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{userId}/delete/{todoId}")
    public void delete(@PathVariable("userId") Long userId, @PathVariable("todoId") Long todoId) {
        if (todoRepository.checkTodobyUserIdAndTodoId(userId, todoId).size() != 0) {
            todoRepository.deleteById(todoId);
        }
    }

}
