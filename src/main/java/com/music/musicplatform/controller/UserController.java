package com.music.musicplatform.controller;

import com.music.musicplatform.common.ResponseResult;
import com.music.musicplatform.domain.User;
import com.music.musicplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseResult<?> register(@RequestBody User user) {
        userService.register(user);
        return ResponseResult.success();
    }

    @PostMapping("/login")
    public ResponseResult<String> login(@RequestBody User user) {
        String token = userService.login(user.getUsername(), user.getPassword());
        return ResponseResult.success(token);
    }
}