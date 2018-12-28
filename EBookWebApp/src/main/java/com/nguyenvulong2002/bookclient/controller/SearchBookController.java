package com.nguyenvulong2002.bookclient.controller;

import java.util.List;

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
import com.nguyenvulong2002.bookclient.pm.MainBookPM;
import com.nguyenvulong2002.bookclient.pm.SearchBookPM;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@Controller
public class SearchBookController {

	@Autowired
	private SearchBookPM bookDAO;

	@RequestMapping(value = "/menuWithSearchData", method = RequestMethod.GET)
	public String viewSearchedMenu(@RequestParam(required=false, name = "bookName") String bookName, 
			@RequestParam(required=false, name = "categoryId") String categoryId, 
			@RequestParam(required=false, name = "authorId") String authorId, 
			@RequestParam(required=false, name = "page") String page, 
			Model model) {
		String currentPage = "1";
		if(page!=null && !page.isEmpty()) {
			currentPage = page;
		}
		System.out.println("CATEGORY ------------------" +categoryId);
		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle(bookName);
		requestBook.setPage(currentPage);
		requestBook.setCategoryId(categoryId);
		requestBook.setAuthorId(authorId);
		requestBook.setRowPerPage(BookConts.ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.execute(requestBook);
		
		
		if(reponse == null) {
			return "menuWithSearchData";
		}
		
		List<BookInfo> listResult = reponse.getBooks();

		Integer rpPage = Integer.parseInt(reponse.getPage());
		Integer rpTotalPage = Integer.parseInt(reponse.getTotalPages());

		if(listResult == null || listResult.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
			return "menuWithSearchData";
		}
		
		
		String data = "";
		String key = "";
		
		if(bookName!=null) {
			data = bookName;
			key = "bookName";
		}else if(categoryId != null) {
			data = categoryId;
			key = "categoryId";
		}else if(authorId != null) {
			data = authorId;
			key = "authorId";
		}
		model.addAttribute("key", key);
		model.addAttribute("data", data);
		model.addAttribute("books", listResult);
		model.addAttribute("rpPage", rpPage);
		model.addAttribute("rpTotalPage", rpTotalPage);

		return "menuWithSearchData";
	}
}
