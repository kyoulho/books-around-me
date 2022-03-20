package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.PageMaker;
import com.kyoulho.booksAroundMe.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/searchBook")
    public void searchBook(PageMaker pageMaker, Model model) {
        Map<String, Object> map = bookService.searchBook(pageMaker.getKeyword(), pageMaker.getPage());
        pageMaker.setTotalCount((int) map.get("totalCount"));
        model.addAttribute("pageMaker", pageMaker);
        model.addAttribute("list", map.get("list"));
    }

    @GetMapping("/detailBook")
    public void detailBook() {

    }

}
