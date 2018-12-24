package com.nguyenvulong2002.bookclient.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nguyenvulong2002.bookclient.base.ResponseBase;
import com.nguyenvulong2002.bookclient.model.BookInfo;


@JsonIgnoreProperties(ignoreUnknown = true)
public class BookInfoResponse extends ResponseBase {
	
	@JsonProperty("listBooks")
	private List<BookInfo> books;
	
	@JsonProperty("rspMsg")
	private String rspMsg;
	
	@JsonProperty("rspCd")
	private String rspCd;
	
	@JsonProperty("page")
	private String page;
	
	@JsonProperty("totalRows")
	private String totalRows;
	
	@JsonProperty("totalPages")
	private String totalPages;
	
	public BookInfoResponse() {
		super();
	}

	public BookInfoResponse(List<BookInfo> books, String rspMsg, String rspCd, String page, String totalRows,
			String totalPages) {
		super();
		this.books = books;
		this.rspMsg = rspMsg;
		this.rspCd = rspCd;
		this.page = page;
		this.totalRows = totalRows;
		this.totalPages = totalPages;
	}

	public String getRspMsg() {
		return rspMsg;
	}

	public void setRspMsg(String rspMsg) {
		this.rspMsg = rspMsg;
	}

	public String getRspCd() {
		return rspCd;
	}

	public void setRspCd(String rspCd) {
		this.rspCd = rspCd;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(String totalRows) {
		this.totalRows = totalRows;
	}

	public String getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}

	public List<BookInfo> getBooks() {
		return books;
	}

	public void setBooks(List<BookInfo> books) {
		this.books = books;
	}
	
	
}
