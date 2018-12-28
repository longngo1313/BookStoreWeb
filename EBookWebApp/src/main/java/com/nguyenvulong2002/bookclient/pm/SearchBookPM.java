package com.nguyenvulong2002.bookclient.pm;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.nguyenvulong2002.bookclient.DTO.BookInfoRequest;
import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.base.BasePm;
import com.nguyenvulong2002.bookclient.bf.BookBFImpl;
import com.nguyenvulong2002.bookclient.bf.IBookBF;

@Repository
public class SearchBookPM  implements BasePm<BookInfoRequest, BookInfoResponse>{

	private IBookBF bf = new BookBFImpl();
	
	@Override
	public BookInfoResponse execute(BookInfoRequest request) {
		
		HttpEntity<?> httpEntity = toEntity(request);
		
		ResponseEntity<BookInfoResponse[]> outData;
		
		if(request.getBookTitle() != null) {
			outData = bf.retriveListBookByTitle(httpEntity);
			System.out.println("TITLE");
		}else if(request.getCategoryId() != null) {
			outData = bf.retriveBookByCategoryId(httpEntity);
			System.out.println("CATEGORY");
		}else if(request.getAuthorId() != null) {
			outData = bf.retriveBookByAuthorId(httpEntity);
			System.out.println("AUTHOR");
		}else {
			outData = null;
		}
		
		BookInfoResponse result = toDTO(outData);
		
		return result;
	}

	private HttpEntity<?> toEntity(BookInfoRequest requestBook){
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<?> httpEntity = new HttpEntity<BookInfoRequest>(requestBook, requestHeaders);
		return httpEntity;
	}
	
	private BookInfoResponse toDTO(ResponseEntity<BookInfoResponse[]> outData){
		if(outData == null) { return null; }
		if(outData.getBody() == null || outData.getBody().length == 0) { return null; }
		return outData.getBody()[0];
	}
}
