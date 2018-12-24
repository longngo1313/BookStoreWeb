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
	
	@JsonProperty("imageCloud")
	private String coverImage;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("downloadLink")
	private String downloadLink;

	public BookInfo() {
		super();
	}

	

	public BookInfo(String bookId, String bookTitle, String bookDescription, String bookPage, String bookFormat,
			String bookEdition, String bookISBN, String postDate, List<AuthorInfo> author, String coverImage,
			String category, String downloadLink) {
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
		this.coverImage = coverImage;
		this.category = category;
		this.downloadLink = downloadLink;
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



	public String getCoverImage() {
		return coverImage;
	}



	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getDownloadLink() {
		return downloadLink;
	}



	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}



	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookDescription=" + bookDescription
				+ ", bookPage=" + bookPage + ", bookFormat=" + bookFormat + ", bookEdition=" + bookEdition
				+ ", bookISBN=" + bookISBN + ", postDate=" + postDate + ", author=" + author + ", coverImage="
				+ coverImage + ", category=" + category + ", downloadLink=" + downloadLink + "]";
	}


	

}
