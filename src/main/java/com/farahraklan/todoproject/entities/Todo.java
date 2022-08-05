package com.farahraklan.todoproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "todo_db")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long todoId;

    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    @NotBlank(message = "Task is required")
    private String task;

    @Getter
    @Setter
    private boolean complete;

}
