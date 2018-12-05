package com.nguyenvulong2002.bookclient.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;


@Repository
public class BookInfoDAO {

	private static final String BASE_URL = "http://54.145.176.109/";

	private static final String GET_LIST_BOOK_DETAIL = "freebookstore/api/v1/get-list-books";

	private static final String SEARCH_BOOK_BY_ID = "freebookstore/api/v1/search-by-book-id={bookId}";

	private static final String SEARCH_BOOK_BY_WORD = "freebookstore/api/v1/search-by-text={inputText}";

	public List<BookInfo> getListBookDetail(){

		RestTemplate restTemplate = new RestTemplate();
		String newQuery = BASE_URL + GET_LIST_BOOK_DETAIL;
		
		BookInfoResponse response = restTemplate.getForObject(newQuery, BookInfoResponse.class);
		List<BookInfo> list = response.getBooks();

		if (list != null) {
			LoggerUtil.setLog(this, eStatusLog.INFO, "", list);
			return list;
		}else {
			LoggerUtil.setLog(this, eStatusLog.INFO, "", " IS NULL");
			return null;
		}
	}

	public List<BookInfo> getListBookDetail2(){
		RestTemplate restTemplate = new RestTemplate();
		String newQuery = BASE_URL + GET_LIST_BOOK_DETAIL;
		
		@SuppressWarnings("unchecked")
		LinkedHashMap<String, Object> usersMap = restTemplate.getForObject(newQuery, LinkedHashMap.class);

		@SuppressWarnings("unchecked")
		List<BookInfo>  bookInfos = (List<BookInfo>) usersMap.get("books");
		return bookInfos;
	}

	public BookInfo getBookById(String id) {
		String newQuery = BASE_URL + SEARCH_BOOK_BY_ID;
		RestTemplate restTemplate = new RestTemplate();
		
		BookInfoResponse bookResponse = restTemplate.getForObject( newQuery, BookInfoResponse.class, id);
		
		if(bookResponse == null) {
			return null;
		}
		
		if(bookResponse.getBooks() == null) {
			return null;
		}
		
		if(bookResponse.getBooks().isEmpty()) {
			return null;
		}
		BookInfo book = bookResponse.getBooks().get(0);
		
		return book;
	}

	public List<BookInfo> getListBookByTitle(String title){
		RestTemplate restTemplate = new RestTemplate();
		String newQuery = BASE_URL + SEARCH_BOOK_BY_WORD;
		
		BookInfoResponse response = restTemplate.getForObject(newQuery, BookInfoResponse.class, title);
		
		List<BookInfo> list = response.getBooks();

		if (list != null) {
			LoggerUtil.setLog(this, eStatusLog.INFO, "", list);
			return list;
		}else {
			LoggerUtil.setLog(this, eStatusLog.INFO, "", " DATA IS NULL");
			return null;
		}
	}





}
