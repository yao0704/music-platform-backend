package com.music.musicplatform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SongList {
    private Long id;
    private Long userId;          // 创建者ID
    private String title;         // 歌单标题
    private String description;   // 简介
    private String cover;         // 封面
    private LocalDateTime createTime;
}
