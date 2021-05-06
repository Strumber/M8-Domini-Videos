package com.video.domain;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private int video_id;
	private String Url;
	private String titol;
	private String tags;
	
	public Video(int video_id, String url, String titol, String tags) {
		super();
		this.video_id = video_id;
		Url = url;
		this.titol = titol;
		this.tags = tags;
	}

	public int getVideo_id() {
		return video_id;
	}

	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getTitol() {
		return titol;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}
	

}
