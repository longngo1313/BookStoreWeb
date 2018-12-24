package com.nguyenvulong2002.bookclient.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfoRequest {

	
	@JsonProperty("rowPerPage")
	private String rowPerPage;
	
	@JsonProperty("page")
	private String page;
	
	@JsonProperty("bookId")
	private String bookId;
	
	@JsonProperty("bookTitle")
	private String bookTitle;

	

	public BookInfoRequest(String rowPerPage, String page, String bookId, String bookTitle) {
		super();
		this.rowPerPage = rowPerPage;
		this.page = page;
		this.bookId = bookId;
		this.bookTitle = bookTitle;
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

	
}
