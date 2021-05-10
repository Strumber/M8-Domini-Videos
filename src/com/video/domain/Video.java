package com.video.domain;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;



public class Video {
	protected int video_id;
	protected String Url;
	protected String titol;
	protected List<Tag> tags = new ArrayList<>();
	protected Date data_pujada;

	public Video(int video_id, String url, String titol, List<Tag> llistatags,Date data_pujada) throws Exception {

		this.video_id = video_id;
		this.Url = url;
		this.titol = titol;
		this.tags = llistatags;
		this.data_pujada=data_pujada;
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

	public Date getData_pujada() {
		return data_pujada;
	}

	public void setData_pujada(Date data_pujada) {
		this.data_pujada = data_pujada;
	}

}
