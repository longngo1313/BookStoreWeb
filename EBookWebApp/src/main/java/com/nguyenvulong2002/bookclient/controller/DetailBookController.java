package com.nguyenvulong2002.bookclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvulong2002.bookclient.DTO.BookInfoRequest;
import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.constant.BookConts;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.pm.DetailBookPM;
import com.nguyenvulong2002.bookclient.pm.MainBookPM;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@Controller
public class DetailBookController {
	
	@Autowired
	private DetailBookPM bookDAO;
	
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String viewBook(@RequestParam(required=false, name = "bookId") String bookId, Model model) {

		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookId(bookId);
		requestBook.setPage("1");
		requestBook.setRowPerPage(BookConts.ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.execute(requestBook);
		
		BookInfo book = reponse.getBooks().get(0);
		
		LoggerUtil.setLog(this, eStatusLog.INFO, "viewBook", book);

		if(book == null) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("book", book);
		}
		return "bookDetail";
	}
}
