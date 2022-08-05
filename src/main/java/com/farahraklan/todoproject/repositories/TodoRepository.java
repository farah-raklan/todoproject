package com.farahraklan.todoproject.repositories;

import com.farahraklan.todoproject.entities.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Query("SELECT u FROM Todo u WHERE u.userId = :userId")
    public List<Todo> findAllByUserId(@Param("userId") Long userId);

    @Query("SELECT u FROM Todo u WHERE u.userId = :userId AND u.todoId = :todoId")
    public List<Todo> checkTodobyUserIdAndTodoId(@Param("userId") Long userId,@Param("todoId") Long todoId);

}
