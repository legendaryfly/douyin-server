package com.anoyi.douyin.mapper;

import java.util.List;

import com.anoyi.douyin.entity.Aweme;
import com.anoyi.douyin.entity.DyUser;
import com.anoyi.douyin.entity.DyUserVO;
import com.anoyi.douyin.entity.TotalUser;

public interface DouyinMapper {
	
	/**
     * 获取所有任务用户
     * */
	List<DyUser> listDyUser();

	/**
     * 添加抖音用户信息
     * */
	void insertDyUserVO(DyUserVO user);
	
	/**
     * 添加抖音用户视频信息
     * */
	void insertDyAweme(Aweme video);
	
	
	/**
     * 验证抖音用户信息
     * */
	int isHasDyUser(String dy_id);
	/**
     * 新增需要爬取的抖音用户信息
     * */
	void insertDyUser(DyUser user);
	
	/**
     * 删除需要爬取的抖音用户信息
     * */
	void delDyUser(String dy_id);
	
	
	List<TotalUser> getTotalList(String add_time);
	
	
}
