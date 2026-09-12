package com.music.musicplatform.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListSong {
    private Long id;
    private Long songListId;
    private Long songId;
    private LocalDateTime createTime;
}
