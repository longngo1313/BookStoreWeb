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
import com.nguyenvulong2002.bookclient.utils.LoggerUtil;
import com.nguyenvulong2002.bookclient.utils.LoggerUtil.eStatusLog;

@Controller
public class MainBookController {
	
	@Autowired
	private MainBookPM bookDAO;
	
	
	
	@RequestMapping(value = {"/" , "/menu"}, method = RequestMethod.GET)
	public String viewMenu(@RequestParam(required=false, name = "bookName") String searchBook, Model model) {


		BookInfoRequest requestBook = new BookInfoRequest();
		requestBook.setBookTitle("");
		requestBook.setPage("1");
		requestBook.setRowPerPage(BookConts.ROW_PER_PAGE);

		BookInfoResponse  reponse =  bookDAO.execute(requestBook);
		
		List<BookInfo> listBook = reponse.getBooks();
		
		
		if(listBook == null || listBook.isEmpty()) {
			model.addAttribute("errorMsg", "Data not found");
			LoggerUtil.setLog(this, eStatusLog.INFO, "errorMsg", "----------------------------");
			return "menu";
		}
		
		List<BookInfo> upperList  = listBook.subList(1, 4);
		List<BookInfo> lowerList  = listBook.subList(5, 8);
		model.addAttribute("upperList", upperList);
		model.addAttribute("lowerList", lowerList);
	
		return "menu";
	}
}
