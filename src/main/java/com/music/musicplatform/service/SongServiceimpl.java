package com.music.musicplatform.service;

import com.music.musicplatform.domain.Song;
import com.music.musicplatform.mapper.SongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceimpl implements SongService{
    @Autowired
    private SongMapper songMapper;
    @Override
    public List<Song> getList(String style) {
        return songMapper.selectList(style);
    }

    @Override
    public Song getById(Long id) {
        Song song = songMapper.selectById(id);
        if (song == null) {
            throw new RuntimeException("歌曲不存在");
        }
        return song;
    }

    @Override
    public List<String> getStyles() {
        return songMapper.selectDistinctStyles();
    }
}
