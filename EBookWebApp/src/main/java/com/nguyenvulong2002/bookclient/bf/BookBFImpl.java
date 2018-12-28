package com.nguyenvulong2002.bookclient.bf;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.bf.book.RetriveBookByAuthorId;
import com.nguyenvulong2002.bookclient.bf.book.RetriveBookByCategoryId;
import com.nguyenvulong2002.bookclient.bf.book.RetriveBookById;
import com.nguyenvulong2002.bookclient.bf.book.RetriveListBookByTitle;

public class BookBFImpl implements IBookBF {

	@Override
	public ResponseEntity<BookInfoResponse[]> retriveListBookByTitle(HttpEntity<?> httpEntity) {
		RetriveListBookByTitle retriveListBookByTitle = new RetriveListBookByTitle();
		return retriveListBookByTitle.execute(httpEntity);
	}

	@Override
	public ResponseEntity<BookInfoResponse[]> retriveBookById(HttpEntity<?> httpEntity) {
		RetriveBookById retriveBookById = new RetriveBookById();
		return retriveBookById.execute(httpEntity);
	}

	@Override
	public ResponseEntity<BookInfoResponse[]> retriveBookByCategoryId(HttpEntity<?> httpEntity) {
		RetriveBookByCategoryId retriveBookByCategoryId = new RetriveBookByCategoryId();
		return retriveBookByCategoryId.execute(httpEntity);
	}

	@Override
	public ResponseEntity<BookInfoResponse[]> retriveBookByAuthorId(HttpEntity<?> httpEntity) {
		RetriveBookByAuthorId retriveBookByAuthorId = new RetriveBookByAuthorId();
		return retriveBookByAuthorId.execute(httpEntity);
	}

}
