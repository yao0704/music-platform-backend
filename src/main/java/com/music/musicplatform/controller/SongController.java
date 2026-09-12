package com.music.musicplatform.controller;

import com.music.musicplatform.common.ResponseResult;
import com.music.musicplatform.domain.Song;
import com.music.musicplatform.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {
    @Autowired
    private SongService songService;
//    歌曲列表
    public ResponseResult<List<Song>> list(@RequestParam(required = false) String style) {
        return ResponseResult.success(songService.getList(style));
    }
//歌曲详情
    @GetMapping("/{id:\\d+}")
    public ResponseResult<Song> detail(@PathVariable Long id) {
        return ResponseResult.success(songService.getById(id));
    }

    // 所有可选风格
    @GetMapping("/styles")
    public ResponseResult<List<String>> styles() {
        return ResponseResult.success(songService.getStyles());
    }

}
