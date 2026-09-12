package com.music.musicplatform.mapper;

import com.music.musicplatform.domain.Mv;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MvMapper {
    List<Mv> selectList(String style);

    Mv selectById(Long id);

    List<String> selectDistinctStyles();
}
