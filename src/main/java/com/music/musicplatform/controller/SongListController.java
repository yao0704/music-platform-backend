package com.music.musicplatform.controller;

import com.music.musicplatform.common.ResponseResult;
import com.music.musicplatform.domain.Song;
import com.music.musicplatform.domain.SongList;
import com.music.musicplatform.service.SongListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/songList")
public class SongListController {
    @Autowired
    private SongListService songListService;
    // 当前用户的歌单列表
    @GetMapping("/list")
    public ResponseResult<List<SongList>> list(HttpServletRequest request) {
        Long userId = getUserId(request);
        return ResponseResult.success(songListService.getMyLists(userId));
    }

    // 创建歌单
    @PostMapping("/add")
    public ResponseResult<?> add(@RequestBody Map<String, String> body, HttpServletRequest request) {
        Long userId = getUserId(request);
        songListService.addList(userId, body.get("title"), body.get("description"));
        return ResponseResult.success();
    }

    // 歌单里的歌曲
    @GetMapping("/{id:\\d+}/songs")
    public ResponseResult<List<Song>> songs(@PathVariable("id") Long id, HttpServletRequest request) {
        Long userId = getUserId(request);
        return ResponseResult.success(songListService.getSongsByListId(id, userId));
    }

    // 往歌单加歌
    @PostMapping("/addSong")
    public ResponseResult<?> addSong(@RequestBody Map<String, Long> body, HttpServletRequest request) {
        Long userId = getUserId(request);
        songListService.addSongToList(body.get("songListId"), body.get("songId"), userId);
        return ResponseResult.success();
    }

    // 从 request 取出拦截器放进去的 userId
    private Long getUserId(HttpServletRequest request) {
        return Long.valueOf((String) request.getAttribute("userId"));
    }
}
