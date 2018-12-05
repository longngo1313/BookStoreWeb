package com.nguyenvulong2002.bookclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorInfo {
	
	@JsonProperty("authorId")
	private String authorId;
	
	@JsonProperty("authorName")
	private String authorName;
	
	@JsonProperty("authorAbout")
	private String authorAbout;

	public AuthorInfo() {
		super();
	}

	public AuthorInfo(String authorId, String authorName, String authorAbout) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.authorAbout = authorAbout;
	}

	public String getAuthorAbout() {
		return authorAbout;
	}

	public void setAuthorAbout(String authorAbout) {
		this.authorAbout = authorAbout;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	
}
