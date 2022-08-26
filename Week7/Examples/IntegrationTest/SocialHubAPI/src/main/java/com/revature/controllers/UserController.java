package com.revature.controllers;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.InvalidUserException;
import com.revature.models.User;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private UserService us;

    @Autowired
    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping("/user/")
    public ResponseEntity<Object> handleRegisterUser(@RequestBody LinkedHashMap<String, String> body){

        try{
            User u = us.registerNewUser(body.get("firstName"), body.get("lastName"), body.get("username"), body.get("email"), body.get("password"));
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>("Invalid username or email", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/user")
    public User getCurrentUser(@RequestParam(name="id")int id){
        return us.getCurrentUserById(id);
    }

    @PostMapping("/user/login")
    public ResponseEntity<Object> handleLoginUser(@RequestBody LinkedHashMap<String, String> body){

        String username = body.get("username");
        String password = body.get("password");

        try{
            return new ResponseEntity<>(us.loginUser(username, password), HttpStatus.ACCEPTED);
        } catch(InvalidCredentialsException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping("/user/follow")
    public User handleFollowUser(@RequestParam(name="user")int user, @RequestParam(name="toFollow")int toFollow){
        return us.followUser(user, toFollow);
    }

    @GetMapping("/users/followers/{id}")
    public Set<User> getUserFollowers(@PathVariable("id")int id){
        return us.getCurrentUserById(id).getFollowers();
    }

    @GetMapping("/users/following/{id}")
    public Set<User> getUserFollowing(@PathVariable("id")int id){
        return us.getCurrentUserById(id).getFollowing();
    }

}
