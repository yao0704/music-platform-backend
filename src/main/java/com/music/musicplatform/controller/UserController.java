package com.music.musicplatform.controller;

import com.music.musicplatform.common.ResponseResult;
import com.music.musicplatform.domain.User;
import com.music.musicplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    // 获取当前用户信息（GET）
    @GetMapping("/info")
    public ResponseResult<User> info(HttpServletRequest request) {
        Long userId = getUserId(request);
        return ResponseResult.success(userService.getInfo(userId));
    }

    // 修改当前用户信息（PUT）
    @PutMapping("/info")
    public ResponseResult<?> updateInfo(@RequestBody User user, HttpServletRequest request) {
        Long userId = getUserId(request);
        user.setId(userId);   // 强制使用token里的userId，防止越权修改他人
        userService.updateInfo(user);
        return ResponseResult.success();
    }

    // 从 request 取 userId（和 SongListController 一样）
    private Long getUserId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute("userId"));
    }
}