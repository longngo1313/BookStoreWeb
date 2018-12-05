package com.nguyenvulong2002.bookclient.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvulong2002.bookclient.dao.BookInfoDAO;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@Controller
public class BookController {

	@Autowired
	private BookInfoDAO bookDAO;
	
	@RequestMapping(value = { "/", "/listbooks" }, method = RequestMethod.GET)
	public String viewListBook(Model model) {
		List<BookInfo> listBook = bookDAO.getListBookDetail();
		LoggerUtil.setLog(this, eStatusLog.INFO, "", listBook);
		model.addAttribute("books", listBook);
		return "listBook";
	}
	
	@RequestMapping(value = "/searchedBooks", method = RequestMethod.GET)
	public String showListBookByTitle(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {
		LoggerUtil.setLog(this, eStatusLog.INFO, " searchBook ", searchBook);
		List<BookInfo> listBook = bookDAO.getListBookByTitle(searchBook);
		LoggerUtil.setLog(this, eStatusLog.INFO, "", listBook);
		
		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("books", listBook);
		}
		return "searchedBooks";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String viewMenu(Model model) {
		return "menu";
	}
	
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String viewBook(@RequestParam(required=false, name = "bookId") String bookId, Model model) {
		
		LoggerUtil.setLog(this, eStatusLog.INFO, " bookId ", bookId);
		BookInfo book = bookDAO.getBookById(bookId);
		LoggerUtil.setLog(this, eStatusLog.INFO, "", book);
		
		if(book == null) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("book", book);
		}
		return "bookDetail";
	}
}
