package com.anoyi.douyin.entity;

import lombok.Data;

import java.util.List;

@Data
public class DyAweme {

    private List<Aweme> aweme_list;
    private int has_more;
    private long max_cursor;
    private long min_cursor;
    private long status_code;
    
   

}
