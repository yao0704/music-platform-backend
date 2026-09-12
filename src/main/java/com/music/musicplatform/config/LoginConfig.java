package com.music.musicplatform.config;

import com.music.musicplatform.common.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)   // 添加拦截器
                .addPathPatterns("/**")            // 拦截所有路径
                .excludePathPatterns(              // 放行以下公开接口
                        "/user/login",             // 登录
                        "/user/register",          // 注册
                        "/song/**",                // 歌曲相关（游客可看）
                        "/mv/**"                   // MV相关（游客可看）
                );
    }
}
