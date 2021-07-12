package com.laonstory.todo.controller;

import com.laonstory.todo.domain.entity.User;
import com.laonstory.todo.dto.UserDto;
import com.laonstory.todo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
        return userService.login(user);
    }
    */

    @PostMapping("/signup")
    public void SignUp(@RequestBody User user){
        userService.signup(user);
    }
}
