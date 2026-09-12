package com.music.musicplatform.mapper;

import com.music.musicplatform.domain.SongList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SongListMapper {
    List<SongList> selectByUserId(@Param("userId") Long userId);
    int insert(SongList songList);
    SongList selectById(@Param("songListId") Long songListId);
}
