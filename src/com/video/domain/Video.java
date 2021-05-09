package com.video.domain;

import java.util.ArrayList;
import java.util.List;

import com.video.application.camps_buits;

public class Video {
	protected int video_id;
	protected String Url;
	protected String titol;
	protected List<Tag> tags = new ArrayList<>();

	public Video(int video_id, String url, String titol, List<Tag> llistatags) throws Exception {

		this.video_id = video_id;
		this.Url = url;
		this.titol = titol;
		this.tags = llistatags;
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

	public List<Tag> getLTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

}
