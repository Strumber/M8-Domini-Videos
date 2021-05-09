package com.video.domain;

//import java.util.Scanner;

public class Tag {
	protected int tag_id;
	protected String tags;

	public Tag(int tag_id, String tags) {
		// super();
		this.tag_id = tag_id;
		this.tags = tags;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getTag_id() {
		return tag_id;
	}

	public void setTag_id(int tag_id) {
		this.tag_id = tag_id;
	}

}
