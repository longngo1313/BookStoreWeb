package com.nguyenvulong2002.bookclient.pm;

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
import com.nguyenvulong2002.bookclient.base.BasePm;
import com.nguyenvulong2002.bookclient.bf.BookBFImpl;
import com.nguyenvulong2002.bookclient.bf.IBookBF;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;


@Repository
public class MainBookPM implements BasePm<BookInfoRequest, BookInfoResponse>{
	
	private IBookBF bf = new BookBFImpl();
	
	@Override
	public BookInfoResponse execute(BookInfoRequest requestBook){
		
		HttpEntity<?> httpEntity = toEntity(requestBook);
		
		ResponseEntity<BookInfoResponse[]> outData = bf.retriveListBookByTitle(httpEntity);
		
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
		return outData.getBody()[0];
	}
	
}
