package com.music.musicplatform.mapper;

import com.music.musicplatform.domain.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ListSongMapper {
    List<Song> selectSongsByListId(@Param("songListId") Long songListId);
    int insert(@Param("songListId") Long songListId, @Param("songId") Long songId);
    int selectCount(@Param("songListId") Long songListId, @Param("songId") Long songId);
}
