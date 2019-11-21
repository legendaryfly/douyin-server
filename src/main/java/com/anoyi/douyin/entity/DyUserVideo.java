package com.anoyi.douyin.entity;

import lombok.Data;

@Data
public class DyUserVideo {
	private String videoId;
	private String dyId;
	private String awemeId;
	private String desc;
	private Integer awemeType;
	private Integer mediaType;
	private Integer diggCount;
	private Integer commentCount;
	private Integer playCount;
	private Integer shareCount;
	private Integer forwardCount;
	private String coverImg;
	private String addTime;
}
