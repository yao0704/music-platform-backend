package com.music.musicplatform.service;

import com.music.musicplatform.domain.Song;
import com.music.musicplatform.domain.SongList;

import java.util.List;

public interface SongListService {
    List<SongList> getMyLists(Long userId);
    void addList(Long userId, String title, String description);
    List<Song> getSongsByListId(Long songListId, Long userId);
    void addSongToList(Long songListId, Long songId, Long userId);
}
