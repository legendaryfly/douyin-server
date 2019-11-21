package com.anoyi.douyin.entity;

import java.util.List;

import lombok.Data;

@Data
public class TotalPage {
	private List<TotalUser> list;
	
    private Integer total_focus=0;
    
    private Integer total_follower=0;
    
    private Integer total_likenum=0;
    
    private Integer total_opus=0;
    
    private Integer total_digg=0;
    
    private Integer total_comment=0;
    
    private Integer total_play=0;
    
    private Integer total_share=0;
}
