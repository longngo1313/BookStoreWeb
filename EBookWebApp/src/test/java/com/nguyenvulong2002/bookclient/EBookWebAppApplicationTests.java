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
public class EBookWebAppApplicationTests {
	@Test
	public void defaultTest() {
		assertNotNull("Default");
	}


}
