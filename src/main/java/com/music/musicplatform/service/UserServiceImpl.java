package com.music.musicplatform.service;

import com.music.musicplatform.common.JwtUtil;
import com.music.musicplatform.domain.User;
import com.music.musicplatform.mapper.UserMapper;
import com.music.musicplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void register(User user) {
        User exist = userMapper.selectByUsername(user.getUsername());
        if (exist != null) {
            throw new RuntimeException("用户名已存在");
        }
        String encrypted = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(encrypted);
        if (user.getNickname() == null || user.getNickname().isEmpty()) {
            user.setNickname(user.getUsername());
        }
        userMapper.insert(user);
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        String encrypted = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!encrypted.equals(user.getPassword())) {
            throw new RuntimeException("密码错误");
        }
        return jwtUtil.generateToken(user.getId(), user.getUsername());

    }
    @Override
    public User getInfo(Long id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        user.setPassword(null);
        return user;
    }

    @Override
    public void updateInfo(User user) {
        User exist = userMapper.selectById(user.getId());
        if (exist == null) {
            throw new RuntimeException("用户不存在");
        }
        userMapper.updateById(user);
    }
}