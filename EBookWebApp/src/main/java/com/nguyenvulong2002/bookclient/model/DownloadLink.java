package com.nguyenvulong2002.bookclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DownloadLink {
	@JsonProperty("linkId")
	private String linkId;
	
	@JsonProperty("linkUrl")
	private String linkUrl;

	public DownloadLink(String linkId, String linkUrl) {
		super();
		this.linkId = linkId;
		this.linkUrl = linkUrl;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public DownloadLink() {
		super();
	}

	@Override
	public String toString() {
		return "DownloadLink [linkId=" + linkId + ", linkUrl=" + linkUrl + "]";
	}
	
	
}
