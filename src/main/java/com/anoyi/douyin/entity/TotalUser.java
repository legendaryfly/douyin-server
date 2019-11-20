package com.anoyi.douyin.entity;

import lombok.Data;

@Data
public class TotalUser {
	private String user_id;

    private String dy_id;

    private String dy_tk;

    private String nickname;

    private String shortid;

    private String avatar;

    private String sign;
    
    private Integer focus;
    
    private Integer follower;
    
    private Integer likenum;
    
    private Integer opus;
    
    private Integer sum_digg;
    
    private Integer sum_comment;
    
    private Integer sum_play;
    
    private Integer sum_share;
    
    private String add_time;
    
}
