package com.nguyenvulong2002.bookclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoverImage {
	
	@JsonProperty("imageId")
	private String imageId;
	
	@JsonProperty("imageUrl")
	private String imageUrl;

	public CoverImage(String imageId, String imageUrl) {
		super();
		this.imageId = imageId;
		this.imageUrl = imageUrl;
	}

	public CoverImage() {
		super();
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "CoverImage [imageId=" + imageId + ", imageUrl=" + imageUrl + "]";
	}
	
}
