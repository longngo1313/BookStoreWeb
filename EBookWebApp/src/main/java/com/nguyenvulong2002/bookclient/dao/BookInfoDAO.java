package com.nguyenvulong2002.bookclient.dao;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nguyenvulong2002.bookclient.DTO.BookInfoRequest;
import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.model.BookInfo;


@Repository
public class BookInfoDAO {

	private static final String BASE_URL = "http://54.145.176.109/";

	private static final String SEARCH_BOOK_BY_ID = "freebookstore/api/v2/search-book-by-id";

	private static final String SEARCH_LIST_BOOK_BY_KEY_WORD = "freebookstore/api/v2/search-book-by-title";

	
	public BookInfo getBookById(String id) {
		
		String query = BASE_URL + SEARCH_BOOK_BY_ID;
		
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookId(id);
		requestBook.setPage("1");
		requestBook.setRowPerPage("15");
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> httpEntity = new HttpEntity<BookInfoRequest>(requestBook, requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<BookInfoResponse[]> model = restTemplate
				.exchange(query, HttpMethod.POST, httpEntity, BookInfoResponse[].class);
		
		BookInfo book = model.getBody()[0].getBooks().get(0);
		return book;
	}

	public List<BookInfo> getListBookByTitle(String title){
		String query = BASE_URL + SEARCH_LIST_BOOK_BY_KEY_WORD;
		
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle(title);
		requestBook.setPage("1");
		requestBook.setRowPerPage("15");
		
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> httpEntity = new HttpEntity<BookInfoRequest>(requestBook, requestHeaders);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<BookInfoResponse[]> model = restTemplate
				.exchange(query, HttpMethod.POST, httpEntity, BookInfoResponse[].class);
		
		List<BookInfo> books = model.getBody()[0].getBooks();
		return books;

	}


}
