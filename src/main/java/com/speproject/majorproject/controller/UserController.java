package com.speproject.majorproject.controller;

import com.speproject.majorproject.entity.User;
import com.speproject.majorproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUsers")
    public User registerUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/users/signin")
    @ResponseBody
    public User loginUser(@RequestBody Map<String,String> allParams){
        return userService.signinUser(allParams.get("email"), allParams.get("password"));
    }
//    @PostMapping("/users/signin")
//    @ResponseBody
//    public String loginUser(@RequestParam Map<String,String> allParams){
//        return "Parameters are " + allParams.entrySet();
////        return usereturn "Parameters are " + allParams.entrySet();rService.signinUser(email, password);
//    }

    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long userId){
        return userService.getUserById(userId);
    }


}
