package com.music.musicplatform.service;

import com.music.musicplatform.domain.Mv;
import com.music.musicplatform.mapper.MvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MvServiceimpl implements MvService{
    @Autowired
    private MvMapper mvMapper;

    @Override
    public List<Mv> getList(String style) {
        return mvMapper.selectList(style);
    }

    @Override
    public Mv getById(Long id) {
        Mv mv = mvMapper.selectById(id);
        if (mv == null) {
            throw new RuntimeException("MV不存在");
        }
        return mv;
    }

    @Override
    public List<String> getStyles() {
        return mvMapper.selectDistinctStyles();
    }
}
