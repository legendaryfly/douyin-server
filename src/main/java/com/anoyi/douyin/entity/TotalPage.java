package com.anoyi.douyin.entity;

import java.util.List;

import lombok.Data;

@Data
public class TotalPage {
	private List<TotalUser> list;
	
    private Integer total_focus;
    
    private Integer total_follower;
    
    private Integer total_likenum;
    
    private Integer total_opus;
    
    private Integer total_digg;
    
    private Integer total_comment;
    
    private Integer total_play;
    
    private Integer total_share;
}
