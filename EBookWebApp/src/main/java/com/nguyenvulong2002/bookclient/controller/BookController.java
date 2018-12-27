package com.nguyenvulong2002.bookclient.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nguyenvulong2002.bookclient.DTO.BookInfoRequest;
import com.nguyenvulong2002.bookclient.DTO.BookInfoResponse;
import com.nguyenvulong2002.bookclient.dao.BookInfoDAO;
import com.nguyenvulong2002.bookclient.model.BookInfo;
import com.nguyenvulong2002.bookclient.model.PageWrapper;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@Controller
public class BookController {

	@Autowired
	private BookInfoDAO bookDAO;


	private static final String ROW_PER_PAGE = "8";


	@RequestMapping(value = {"/" , "/menu"}, method = RequestMethod.GET)
	public String viewMenu(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {


		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle("");
		requestBook.setPage("1");
		requestBook.setRowPerPage(ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.getListBookByTitle(requestBook);
		
		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle", reponse.getBooks());
		List<BookInfo> listBook = reponse.getBooks();
		List<BookInfo> upperList  = listBook.subList(1, 4);
		List<BookInfo> lowerList  = listBook.subList(5, 8);
		

		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("upperList", upperList);
			model.addAttribute("lowerList", lowerList);
		}
		return "menu";
	}

	@RequestMapping(value = "/menuWithSearchData", method = RequestMethod.GET)
	public String viewSearchedMenu(@RequestParam(required=false, name = "bookName") String searchBook, 
			@RequestParam(required=false, name = "page") String page, 
			Model model) {
		String currentPage = "1";
		if(page!=null && !page.isEmpty()) {
			currentPage = page;
		}
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle(searchBook);
		requestBook.setPage(currentPage);
		requestBook.setRowPerPage(ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.getListBookByTitle(requestBook);
		List<BookInfo> listResult = reponse.getBooks();

		Integer rpPage = Integer.parseInt(reponse.getPage());
		Integer rpTotalPage = Integer.parseInt(reponse.getTotalPages());

		LoggerUtil.setLog(this, eStatusLog.INFO, "showListBookByTitle------------------------------", listResult.size());
		LoggerUtil.setLog(this, eStatusLog.INFO, "rpTotalPage------------------------------", rpTotalPage);
		
		if(listResult == null || listResult.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
		}else {
			model.addAttribute("searchBook", searchBook);
			model.addAttribute("books", listResult);
			model.addAttribute("rpPage", rpPage);
			model.addAttribute("rpTotalPage", rpTotalPage);
		}
		return "menuWithSearchData";
	}

	@RequestMapping(value = "/bookDetail", method = RequestMethod.GET)
	public String viewBook(@RequestParam(required=false, name = "bookId") String bookId, Model model) {

		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookId(bookId);
		requestBook.setPage("1");
		requestBook.setRowPerPage(ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.getBookById(requestBook);
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
