package com.anoyi.douyin.entity;

import com.anoyi.douyin.entity.DyAweme;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DyUserVO {

    private String id;

    private String tk;

    private String avatar;

    private String nickname;

    private String shortId;

    private String signature;

    private String verifyInfo;
    
    private String focus;
    
    private String follower;
    
    private String likenum;
    
    private String opus;
    
    private String add_time;

    private Map<String, String> extraInfo = new HashMap<>();

//    private Map<String, String> followInfo = new HashMap<>();

    private DyAweme videos;

}
