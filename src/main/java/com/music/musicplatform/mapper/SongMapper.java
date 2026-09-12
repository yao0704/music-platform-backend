package com.music.musicplatform.mapper;

import com.music.musicplatform.domain.Song;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SongMapper {
    List<Song> selectList(String style);

    Song selectById(Long id);

    List<String> selectDistinctStyles();
}
