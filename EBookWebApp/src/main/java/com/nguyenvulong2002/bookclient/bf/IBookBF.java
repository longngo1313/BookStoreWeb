package com.nguyenvulong2002.bookclient.bf;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;

public interface IBookBF {

	public ResponseEntity<BookInfoResponse[]> retriveListBookByTitle(HttpEntity<?> httpEntity);
	
	public ResponseEntity<BookInfoResponse[]> retriveBookById(HttpEntity<?> httpEntity);
	
	public ResponseEntity<BookInfoResponse[]> retriveBookByCategoryId(HttpEntity<?> httpEntity);
	
	public ResponseEntity<BookInfoResponse[]> retriveBookByAuthorId(HttpEntity<?> httpEntity);
	
}
