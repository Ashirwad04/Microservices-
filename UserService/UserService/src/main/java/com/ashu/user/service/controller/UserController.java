package com.ashu.user.service.controller;

import com.ashu.user.service.entity.User;
import com.ashu.user.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    //create user

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }


    //user by id

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        User user=userService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }




    // all user
    @GetMapping
    public ResponseEntity<List<User>> allUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }


}
