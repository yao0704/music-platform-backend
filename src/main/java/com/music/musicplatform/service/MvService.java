package com.music.musicplatform.service;

import com.music.musicplatform.domain.Mv;

import java.util.List;

public interface MvService {
    List<Mv> getList(String style);
    Mv getById(Long id);
    List<String> getStyles();
}
