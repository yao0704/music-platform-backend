package com.music.musicplatform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    private Long id;
    private String name;
    private String singerName;      // singer_name
    private String lyricist;       // 作词
    private String composer;       // 作曲
    private String lyrics;          // 歌词
    private String style;           // 分类
    private String cover;           // 封面
    private String url;             // 音频URL
    private Integer duration;       // 时长（秒）
    private LocalDateTime createTime;
}
