package com.music.musicplatform.mapper;

import com.music.musicplatform.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int insert(User user);
    User selectByUsername(@Param("username") String username);
}
