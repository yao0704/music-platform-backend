package com.music.musicplatform.service;

import com.music.musicplatform.domain.Song;

import java.util.List;

public interface SongService {
    List<Song> getList(String style);
    Song getById(Long id);
    List<String> getStyles();
}
