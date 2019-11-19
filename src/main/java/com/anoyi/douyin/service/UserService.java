package com.anoyi.douyin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anoyi.douyin.component.JwtUserDetails;
import com.anoyi.douyin.entity.Resp;
import com.anoyi.douyin.entity.RespFactory;
import com.anoyi.douyin.entity.User;
import com.anoyi.douyin.mapper.UserMapper;
import com.anoyi.douyin.util.JwtUtil;

@Service
public class UserService {

    private final UserMapper userMapper;

    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserMapper userMapper, JwtUtil jwtUtil) {
        this.userMapper = userMapper;
        this.jwtUtil = jwtUtil;
    }

    public User findById(String id) {
        return userMapper.selectByPrimaryKey(Integer.valueOf(id));
    }
    
    public Resp<User> getCurrentUser(String username) {
    	User user = userMapper.selectByUsername(username);
    	return RespFactory.success(user);
    }

    public Resp<Object> login(String username, String password) {
        User user = userMapper.selectByUsername(username);
        if(user == null) {
        	return RespFactory.error("用户名或密码错误");
        }
        if (user.getPassword().equals(password)) {
            JwtUserDetails jwtUserDetails = new JwtUserDetails(user);
            String token = jwtUtil.generateToken(jwtUserDetails);
            return RespFactory.success(token);
        } else {
            return RespFactory.error("用户名或密码错误");
        }
    }
}
