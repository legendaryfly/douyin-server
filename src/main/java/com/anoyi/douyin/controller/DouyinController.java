package com.anoyi.douyin.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anoyi.douyin.entity.DyAweme;
import com.anoyi.douyin.entity.DyUserVO;
import com.anoyi.douyin.entity.Resp;
import com.anoyi.douyin.service.DouyinService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/douyin")
@AllArgsConstructor
@CrossOrigin("*")
public class DouyinController {

    @Autowired
    private DouyinService douyinService;
    
    @GetMapping("/user/{id}")
    public DyUserVO user(@PathVariable("id") String id) {
        return douyinService.getDyUser(id);
    }
    
    @GetMapping("/videos/{id}/{tk}")
    public DyAweme videos(@PathVariable("id") String id,
                          @PathVariable("tk") String tk,
                          @RequestParam(value = "cursor", defaultValue = "0") String cursor) {
        return douyinService.videoList(id, tk, cursor);
    }

    @GetMapping("/video")
    public DyAweme video() {
        return douyinService.videoList();
    }
    
    
	/**
     * 获取
     * */
    @GetMapping("/do")
    public void doDouyin() {
    	douyinService.doDouyin();
    }
	
	
//	/**
//     * 验证抖音用户信息
//     * */
//	 @PostMapping("/has/userbase")
//	public Result isHasDyUser(@RequestBody String dy_id) {
//		douyinService.isHasDyUser(dy_id);
//		return ResultGenerator.genOkResult();
//    }
	/**
     * 新增需要爬取的抖音用户信息
     * */
    @PostMapping("/add/userbase")
    public Resp<Object> insertDyUser(@RequestBody Map<String,Object> map) {
    	return douyinService.insertDyUser(map.get("dy_id").toString());
    }
	
	/**
     * 删除需要爬取的抖音用户信息
     * */
	 @PostMapping("/del/userbase")
	public Resp<Object> delDyUser(@RequestBody Map<String,Object> map) {
		 return douyinService.delDyUser(map.get("dy_id").toString());
    }
	 
	 
	 /**
	     * 总统计分析页面
	 * */
    @GetMapping("/total/list")
    public Resp<Object> getTotalList() {
    	return douyinService.getTotalList();
    }
    
    /**
     * 总统计分析页面
	 * */
	@GetMapping("/detail/user/{id}")
	public Resp<Object> getDyUserDetail(@PathVariable("id") String id) {
		return douyinService.getDyUserDetail(id);
	}



}