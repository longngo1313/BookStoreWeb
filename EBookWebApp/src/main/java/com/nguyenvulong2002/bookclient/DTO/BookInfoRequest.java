package com.nguyenvulong2002.bookclient.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nguyenvulong2002.bookclient.base.RequestBase;
import com.nguyenvulong2002.bookclient.base.ResponseBase;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfoRequest extends RequestBase{

	
	@JsonProperty("rowPerPage")
	private String rowPerPage;
	
	@JsonProperty("page")
	private String page;
	
	@JsonProperty("bookId")
	private String bookId;
	
	@JsonProperty("bookTitle")
	private String bookTitle;
	
	@JsonProperty("categoryId")
	private String categoryId;
	
	@JsonProperty("authorId")
	private String authorId;

	public BookInfoRequest(String rowPerPage, String page, String bookId, String bookTitle, String categoryId, String authorId) {
		super();
		this.rowPerPage = rowPerPage;
		this.page = page;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.categoryId = categoryId;
		this.authorId = authorId;
	}

	public BookInfoRequest() {
		super();
	}

	public String getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(String rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}

}
