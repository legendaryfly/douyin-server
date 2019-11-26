package com.anoyi.douyin.component;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.anoyi.douyin.config.JwtConfig;
import com.anoyi.douyin.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthorizationTokenFilter extends OncePerRequestFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final JwtConfig jwtConfig;

    @Autowired
    public JwtAuthorizationTokenFilter(@Qualifier("jwtUserDetailsService") UserDetailsService userDetailsService,
                                       JwtUtil jwtUtil, JwtConfig jwtConfig) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        final String requestHeader = request.getHeader(jwtConfig.getHeader());
//        System.out.println(request.getRequestURI());
        String username = null;
        String authToken = null;
        if (requestHeader != null && requestHeader.startsWith(jwtConfig.getTokenHead())) {
            authToken = requestHeader.substring(jwtConfig.getTokenHead().length() + 1);
            try {
                username = jwtUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("从 token 获取 username 异常: ", e);
            } catch (ExpiredJwtException e) {
                logger.warn("token 过期或无效: ", e);
            }
        } else {
            logger.warn("没有 bearer 数据，忽略此请求头");
        }

        logger.info("校验 jwt '{}'", username);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                logger.info("通过 jwt 校验 '{}', setting security context", username);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                logger.info("jwt 校验失败 '{}'", username);
            }
        }
        chain.doFilter(request, response);
    }
    
}
