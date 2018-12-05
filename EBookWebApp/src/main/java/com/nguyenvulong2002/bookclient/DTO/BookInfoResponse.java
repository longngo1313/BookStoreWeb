package com.nguyenvulong2002.bookclient.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nguyenvulong2002.bookclient.base.ResponseBase;
import com.nguyenvulong2002.bookclient.model.BookInfo;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfoResponse extends ResponseBase {
	
	@JsonProperty("books")
	private List<BookInfo> books;
	
	public BookInfoResponse() {
		super();
	}

	public BookInfoResponse(List<BookInfo> books) {
		super();
		this.books = books;
	}

	public List<BookInfo> getBooks() {
		return books;
	}

	public void setBooks(List<BookInfo> books) {
		this.books = books;
	}
	
	
}
