package com.nguyenvulong2002.bookclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {
	
	
	@JsonProperty("categoryId")
	private String categoryId;
	
	@JsonProperty("categoryName")
	private String categoryName;

	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category() {
		super();
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	

}
