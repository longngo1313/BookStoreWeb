package com.nguyenvulong2002.bookclient;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nguyenvulong2002.bookclient.DTO.BookInfoRequest;
import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.bf.BookBFImpl;
import com.nguyenvulong2002.bookclient.bf.IBookBF;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.pm.DetailBookPM;
import com.nguyenvulong2002.bookclient.pm.MainBookPM;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookInfoDAOTest {
	
	private static final String BOOK_ID = "IT0000000000";
	
	private static final String TITLE = "Spring";
	
	@Autowired 
	private MainBookPM bookDao;
	
	@Autowired 
	private DetailBookPM detailBookDao;

	
	@Test
	public void getBookByIdTest() {
		
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookId(BOOK_ID);
		requestBook.setPage("1");
		requestBook.setRowPerPage("8");
		
		BookInfoResponse book = detailBookDao.execute(requestBook);
		assertNotNull(book.getBooks());
	}
	
	@Test
	public void getListBookByTitle() {
		
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle(TITLE);
		requestBook.setPage("1");
		requestBook.setRowPerPage("8");
		
		BookInfoResponse list = bookDao.execute(requestBook);
		assertNotNull(list.getBooks());
		assertFalse(list.getBooks().isEmpty());
	}
	
	
}
