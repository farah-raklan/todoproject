package com.farahraklan.todoproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="user_db")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long userId;

    @Getter
    @Setter
    @NotBlank(message = "Email is required")
    private String email;

}
