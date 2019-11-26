package com.anoyi.douyin.entity;

import lombok.Data;

@Data
public class TotalUser {
	private String userId;

    private String dyId;

    private String dyTk;

    private String nickname;

    private String shortid;

    private String avatar;

    private String sign;
    
    private String focus;
    
    private String follower;
    
    private String likenum;
    
    private String opus;
    
    private String sumDigg="0";
    
    private String sumComment="0";
    
    private String sumPlay="0";
    
    private String sumShare="0";
    
    private String addTime="0";
    
}
