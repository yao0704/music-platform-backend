D:\code\java pragram\music-platform\sql\init.sql

CREATE DATABASE IF NOT EXISTS music_platform DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE music_platform;

-- 1. 用户表
CREATE TABLE `user` (
                        `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                        `username`    VARCHAR(50)  NOT NULL COMMENT '登录账号',
                        `password`    VARCHAR(100) NOT NULL COMMENT '密码（MD5加密）',
                        `nickname`    VARCHAR(50)  DEFAULT NULL COMMENT '昵称',
                        `gender`      TINYINT      DEFAULT 0 COMMENT '性别：0保密 1男 2女',
                        `avatar`      VARCHAR(255) DEFAULT NULL COMMENT '头像URL',
                        `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `uk_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 2. 歌曲表
CREATE TABLE `song` (
                        `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '歌曲ID',
                        `name`        VARCHAR(100) NOT NULL COMMENT '歌曲名',
                        `singer_name` VARCHAR(50)  NOT NULL COMMENT '歌手名',
                        `lyricist`    VARCHAR(50)  DEFAULT NULL COMMENT '作词',
                        `composer`    VARCHAR(50)  DEFAULT NULL COMMENT '作曲',
                        `lyrics`      TEXT         COMMENT '歌词',
                        `style`       VARCHAR(20)  DEFAULT NULL COMMENT '分类：流行/摇滚/民谣等',
                        `cover`       VARCHAR(255) DEFAULT NULL COMMENT '封面URL',
                        `url`         VARCHAR(255) NOT NULL COMMENT '音频文件URL',
                        `duration`    INT          DEFAULT 0 COMMENT '时长（秒）',
                        `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='歌曲表';

-- 3. 歌单表
CREATE TABLE `song_list` (
                             `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT '歌单ID',
                             `user_id`     BIGINT       NOT NULL COMMENT '创建者用户ID',
                             `title`       VARCHAR(100) NOT NULL COMMENT '歌单标题',
                             `description` VARCHAR(500) DEFAULT NULL COMMENT '歌单简介',
                             `cover`       VARCHAR(255) DEFAULT NULL COMMENT '封面URL',
                             `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             PRIMARY KEY (`id`),
                             KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='歌单表';

-- 4. 歌单-歌曲关联表（多对多中间表）
CREATE TABLE `list_song` (
                             `id`           BIGINT   NOT NULL AUTO_INCREMENT COMMENT '主键',
                             `song_list_id` BIGINT   NOT NULL COMMENT '歌单ID',
                             `song_id`      BIGINT   NOT NULL COMMENT '歌曲ID',
                             `create_time`  DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `uk_list_song` (`song_list_id`, `song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='歌单歌曲关联表';

-- 5. MV表
CREATE TABLE `mv` (
                      `id`          BIGINT       NOT NULL AUTO_INCREMENT COMMENT 'MV ID',
                      `title`       VARCHAR(100) NOT NULL COMMENT 'MV标题',
                      `artist_name` VARCHAR(50)  NOT NULL COMMENT '作者/歌手',
                      `description` VARCHAR(500) DEFAULT NULL COMMENT 'MV描述',
                      `style`       VARCHAR(20)  DEFAULT NULL COMMENT '分类',
                      `cover`       VARCHAR(255) DEFAULT NULL COMMENT '封面URL',
                      `url`         VARCHAR(255) NOT NULL COMMENT '视频文件URL',
                      `create_time` DATETIME     DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='MV表';

-- ============================================
-- 测试数据
-- ============================================

INSERT INTO `user` (`username`, `password`, `nickname`, `gender`) VALUES
                                                                      ('yao0704', MD5('123456'), '小姚', 1),
                                                                      ('zhangsan', MD5('123456'), '张三', 0);

INSERT INTO `song` (`name`, `singer_name`, `lyricist`, `composer`, `lyrics`, `style`, `url`, `duration`) VALUES
                                                                                                             ('晴天', '周杰伦', '周杰伦', '周杰伦', '故事的小黄花 从出生那年就飘着...', '流行', '/music/qingtian.mp3', 269),
                                                                                                             ('七里香', '周杰伦', '方文山', '周杰伦', '窗外的麻雀 在电线杆上多嘴...', '流行', '/music/qilixiang.mp3', 296),
                                                                                                             ('成都', '赵雷', '赵雷', '赵雷', '让我掉下眼泪的 不止昨夜的酒...', '民谣', '/music/chengdu.mp3', 324);

INSERT INTO `mv` (`title`, `artist_name`, `description`, `style`, `url`) VALUES
    ('晴天MV', '周杰伦', '《晴天》官方MV，收录于专辑《叶惠美》', '流行', '/mv/qingtian.mp4');