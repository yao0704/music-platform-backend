package com.music.musicplatform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mv {
    private Long id;
    private String title;           // MV标题
    private String artistName;      // 作者/歌手
    private String description;     // MV描述
    private String style;           // 分类
    private String cover;           // 封面URL
    private String url;             // 视频文件URL
    private LocalDateTime createTime;
}
