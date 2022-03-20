package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.BookDTO;
import com.kyoulho.booksAroundMe.dto.PageMaker;
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
    public void searchBook(PageMaker pageMaker, Model model) {
       List<BookDTO> list = bookService.getBookList(pageMaker.getKeyword(), pageMaker.getPage());
       int total = bookService.getBookTotal(pageMaker.getKeyword());
       pageMaker.setTotal(total);
       model.addAttribute("pageMaker",pageMaker);
       model.addAttribute("list",list);
    }
    @GetMapping("/detailBook")
    public void detailBook(){

    }

}
