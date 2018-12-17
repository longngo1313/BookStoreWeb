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
		LoggerUtil.setLog(this, eStatusLog.INFO, "viewListBook", listBook);
		model.addAttribute("books", listBook);
		return "listBook";
	}
	
	@RequestMapping(value = "/searchedBooks", method = RequestMethod.GET)
	public String showListBookByTitle(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {
		List<BookInfo> listBook = bookDAO.getListBookByTitle(searchBook);
		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle", listBook);
		
		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("books", listBook);
		}
		return "searchedBooks";
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String viewMenu(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {
		List<BookInfo> listBook = bookDAO.getListBookByTitle("Spring");
		List<BookInfo> newBook  = listBook.subList(1, 4);
		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle", listBook);
		
		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("booksRight", newBook);
			model.addAttribute("booksLeft", newBook);
		}
		return "menu";
	}
	
	@RequestMapping(value = "/menuWithSearchData", method = RequestMethod.GET)
	public String viewSearchedMenu(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {
		
		List<BookInfo> listBook = bookDAO.getListBookByTitle("Spring");
		List<BookInfo> newBook  = listBook.subList(1, 4);
		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle", listBook);
		
		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("booksRight", newBook);
			model.addAttribute("booksLeft", newBook);
		}
		
		//Search book by words
		List<BookInfo> listResult = bookDAO.getListBookByTitle(searchBook);
		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle------------------------------", listResult.size());
		
		if(listResult == null || listResult.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("books", listResult);
		}
		return "menuWithSearchData";
	}
	
	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String viewBook(@RequestParam(required=false, name = "bookId") String bookId, Model model) {
		
		BookInfo book = bookDAO.getBookById(bookId);
		LoggerUtil.setLog(this, eStatusLog.INFO, "viewBook", book);
		
		if(book == null) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("book", book);
		}
		return "bookDetail";
	}
}
