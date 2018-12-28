package com.nguyenvulong2002.bookclient.bf.book;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.constant.BookConts;
import com.nguyenvulong2002.bookclient.constant.RestTemplateInstance;

public class RetriveBookByAuthorId {
	public ResponseEntity<BookInfoResponse[]> execute(HttpEntity<?> httpEntity){
		String query = BookConts.BASE_URL + BookConts.SEARCH_BOOK_BY_AUTHOR_ID;
		return RestTemplateInstance.getInstance()
				.exchange(query, HttpMethod.POST, httpEntity, BookInfoResponse[].class);
	}
}
