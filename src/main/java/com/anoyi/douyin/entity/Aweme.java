package com.anoyi.douyin.entity;

import java.util.List;
import lombok.Data;

@Data
public class Aweme {

	private String dy_id;
	private String aweme_id;
	private String desc;
	private int aweme_type;
	private int media_type;
	private int digg_count;
	private int comment_count;
	private int play_count;
	private int share_count;
	private int forward_count;
	private String cover_img;
	private String add_time;
	private Statistics statistics;
	private List<TextExtra> text_extra;
	private Video video;

	@Data
	public class Statistics {
		private int digg_count;
		private String aweme_id;
		private int comment_count;
		private int play_count;
		private int share_count;
		private int forward_count;
	}

	@Data
	public class TextExtra {
		private int end;
		private String hashtag_name;
		private int start;
		private int type;
	}

	@Data
	public class Video {
		private UrlJSON cover;
		private UrlJSON dynamic_cover;
		private UrlJSON origin_cover;
		private UrlJSON play_addr_lowbr;
		private int height;
		private int width;
		private UrlJSON play_addr;
		private UrlJSON download_addr;
		private String vid;
		private int duration;
		private boolean has_watermark;
		private String ratio;

		@Data
		public class UrlJSON {
			private String uri;
			private String[] url_list;
		}
	}
}
