package com.anoyi.douyin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anoyi.douyin.component.JwtUserDetails;
import com.anoyi.douyin.config.JwtConfig;
import com.anoyi.douyin.entity.LoginReq;
import com.anoyi.douyin.entity.Resp;
import com.anoyi.douyin.entity.RespFactory;
import com.anoyi.douyin.entity.User;
import com.anoyi.douyin.service.UserService;
import com.anoyi.douyin.util.JwtUtil;

@RestController
public class UserController {

    @Autowired
    private JwtConfig jwtConfig;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    @Qualifier("jwtUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Resp<User> getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(jwtConfig.getHeader()).substring(7);
        String username = jwtUtil.getUsernameFromToken(token);
        JwtUserDetails user = (JwtUserDetails) userDetailsService.loadUserByUsername(username);
        return RespFactory.success(user.getUser());
    }
    
    @RequestMapping(value = "/currentUser", method = RequestMethod.POST)
    public Resp<User> getCurrentUser(@RequestBody String username) {
        return userService.getCurrentUser(username);
    }
    

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Resp<Object> login(@Validated @RequestBody LoginReq loginReq, BindingResult bindingResult) {
        return userService.login(loginReq.getUsername(), loginReq.getPassword());
    }
}
