package com.nguyenvulong2002.bookclient.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookInfo {
	
	@JsonProperty("bookId")
	private String bookId;
	
	@JsonProperty("bookTitle")
	private String bookTitle;
	
	@JsonProperty("bookDescription")
	private String bookDescription;
	
	@JsonProperty("bookPage")
	private String bookPage;
	
	@JsonProperty("bookFormat")
	private String bookFormat;
	
	@JsonProperty("bookEdition")
	private String bookEdition;
	
	@JsonProperty("bookISBN")
	private String bookISBN;
	
	@JsonProperty("postDate")
	private String postDate;
	
	@JsonProperty("authors")
	private List<AuthorInfo> author;

	public BookInfo() {
		super();
	}

	public BookInfo(String bookId, String bookTitle, String bookDescription, String bookPage, String bookFormat,
			String bookEdition, String bookISBN, String postDate, List<AuthorInfo> author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.bookPage = bookPage;
		this.bookFormat = bookFormat;
		this.bookEdition = bookEdition;
		this.bookISBN = bookISBN;
		this.postDate = postDate;
		this.author = author;
	}

	public List<AuthorInfo> getAuthor() {
		return author;
	}



	public void setAuthor(List<AuthorInfo> author) {
		this.author = author;
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

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getBookPage() {
		return bookPage;
	}

	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}

	public String getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(String bookFormat) {
		this.bookFormat = bookFormat;
	}

	public String getBookEdition() {
		return bookEdition;
	}

	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	
	
}
