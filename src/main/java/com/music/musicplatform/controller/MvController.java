package com.music.musicplatform.controller;

import com.music.musicplatform.common.ResponseResult;
import com.music.musicplatform.domain.Mv;
import com.music.musicplatform.service.MvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mv")
public class MvController {
    @Autowired
    public MvService mvService;
    @GetMapping("/list")
    public ResponseResult<List<Mv>> list(@RequestParam(required = false) String style) {
        return ResponseResult.success(mvService.getList(style));
    }

    @GetMapping("/{id:\\d+}")
    public ResponseResult<Mv> detail(@PathVariable Long id) {
        return ResponseResult.success(mvService.getById(id));
    }
    @GetMapping("/styles")
    public ResponseResult<List<String>> styles() {
        return ResponseResult.success(mvService.getStyles());
    }
}
