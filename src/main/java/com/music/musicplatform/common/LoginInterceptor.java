package com.music.musicplatform.common;

import io.jsonwebtoken.Claims;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler) throws Exception {
//获取请求头中的token
        String token = request.getHeader("token");
//判断token是否为空，如果为空也代表未登录 提醒重新登录（401）
        if (!StringUtils.hasText(token)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
//解析token看看是否成功
        try {
            Claims claims = jwtUtil.parseToken(token);
            String subject = claims.getSubject();
            System.out.println(subject);
            request.setAttribute("userId",subject);
        } catch (Exception e) {
            e.printStackTrace();
//如果解析过程中没有出现异常说明是登录状态
//如果出现了异常，说明未登录，提醒重新登录（401）
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }
}
