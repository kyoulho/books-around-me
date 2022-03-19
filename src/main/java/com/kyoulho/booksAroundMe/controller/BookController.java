package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.domain.BookVO;
import com.kyoulho.booksAroundMe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/searchBook")
    public void searchBook(@RequestParam String keyword, Model model) {
       List<BookVO> list = bookService.searchBook(keyword);
       model.addAttribute("keyword",keyword);
       model.addAttribute("list",list);
    }
    @GetMapping("/detailBook")
    public void detailBook(){

    }

}
