package com.music.musicplatform.service;

import com.music.musicplatform.domain.User;

public interface UserService {
    void register(User user);
    String login(String username, String password);
}
