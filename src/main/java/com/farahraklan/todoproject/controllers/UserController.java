package com.farahraklan.todoproject.controllers;

import com.farahraklan.todoproject.entities.User;
import com.farahraklan.todoproject.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/")
public class UserController {

    public final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    User currentUser;

    @GetMapping()
    public String home(Authentication authentication) {
        logger.info("Welcome to Homepage");
        if (authentication == null){
            return "WELCOME TO TODO PROJECT HOMEPAGE. PLEASE SIGN IN TO VIEW YOUR TODO TASKS";
        }else{
            if(authentication.isAuthenticated() == true){
                if(currentUser == null){
                    currentUser = checkUser(authentication);
                }
                return "WELCOME BACK TO TODO PROJECT HOMEPAGE. YOU CAN VIEW YOUR TODO TASKS";
            }else{
                return "PLEASE SIGN IN TO VIEW YOUR TODO TASKS";
            }
        }
    }

    @GetMapping("/signin")
    public String signin(Authentication authentication) {
        logger.info("Sign in with google account");
        if(currentUser == null){
            currentUser = checkUser(authentication);
        }
        return "YOU ARE ABLE TO VIEW TODO TASKS";
    }

    @GetMapping("/check")
    public String check(Authentication authentication) {
        logger.info("Checking your id");
        if (authentication == null){
            return "PLEASE SIGN IN TO VIEW YOUR ID";
        }else{
            if(authentication.isAuthenticated() == true){
                if(currentUser == null){
                    currentUser = checkUser(authentication);
                }
                return "YOUR USER ID IS "+ currentUser.getUserId();
            }else{
                return "PLEASE SIGN IN TO VIEW YOUR ID";
            }
        }
    }

    public User checkUser(Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.getUserByEmail(userDetails.getUsername());
        currentUser = user;
        logger.info("Current user is "+user.getEmail());
        return user;
    }

    public User getCurrentUser(){
        return currentUser;
    }
}
