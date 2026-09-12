package com.music.musicplatform.common;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseResult<?> handleException(Exception e) {
        e.printStackTrace();
        return ResponseResult.fail(e.getMessage());
    }
}