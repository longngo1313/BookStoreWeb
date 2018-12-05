package com.nguyenvulong2002.bookclient;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nguyenvulong2002.bookclient.dao.BookInfoDAO;
import com.nguyenvulong2002.bookclient.model.BookInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookInfoDAOTest {
	
	private static final String BOOK_ID = "IT0000000000";
	
	private static final String TITLE = "Spring";
	
	@Autowired 
	private BookInfoDAO bookDao;
	
	@Test
	public void getAllBookTest() {
		List<BookInfo> list = bookDao.getListBookDetail2();
		assertNotNull(list);
	}
	
	@Test
	public void getBookByIdTest() {
		BookInfo book = bookDao.getBookById(BOOK_ID);
		assertNotNull(book);
	}
	
	@Test
	public void getListBookByTitle() {
		List<BookInfo> list = bookDao.getListBookByTitle(TITLE);
		assertNotNull(list);
	}
	
	
}
