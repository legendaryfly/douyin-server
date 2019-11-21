package com.anoyi.douyin.entity;

import java.util.List;
import lombok.Data;

@Data
public class DyUserPage {
	private TotalUser dyUser;
	private List<DyUserVideo> list;
}
