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
    // 新增：根据ID查用户
    User selectById(@Param("id") Long id);

    // 新增：更新用户信息
    int updateById(User user);
}
