package com.music.musicplatform.service;

import com.music.musicplatform.domain.Song;
import com.music.musicplatform.domain.SongList;
import com.music.musicplatform.mapper.ListSongMapper;
import com.music.musicplatform.mapper.SongListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongListServiceimpl implements SongListService{
    @Autowired
    private SongListMapper songListMapper;

    @Autowired
    private ListSongMapper listSongMapper;

    @Override
    public List<SongList> getMyLists(Long userId) {
        return songListMapper.selectByUserId(userId);
    }

    @Override
    public void addList(Long userId, String title, String description) {
        SongList list = new SongList();
        list.setUserId(userId);
        list.setTitle(title);
        list.setDescription(description);
        songListMapper.insert(list);
    }

    @Override
    public List<Song> getSongsByListId(Long songListId, Long userId) {
        SongList list = songListMapper.selectById(songListId);
        if (list == null) {
            throw new RuntimeException("歌单不存在");
        }
        if (!list.getUserId().equals(userId)) {
            throw new RuntimeException("无权访问他人歌单");
        }
        return listSongMapper.selectSongsByListId(songListId);
    }

    @Override
    public void addSongToList(Long songListId, Long songId, Long userId) {
        SongList list = songListMapper.selectById(songListId);
        if (list == null) {
            throw new RuntimeException("歌单不存在");
        }
        if (!list.getUserId().equals(userId)) {
            throw new RuntimeException("无权操作他人歌单");
        }
        int count = listSongMapper.selectCount(songListId, songId);
        if (count > 0) {
            throw new RuntimeException("歌曲已在歌单中");
        }
        listSongMapper.insert(songListId, songId);
    }
}

