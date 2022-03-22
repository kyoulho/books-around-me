package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.PageMaker;
import com.kyoulho.booksAroundMe.dto.SearchRequestDTO;
import com.kyoulho.booksAroundMe.dto.SearchResultDTO;
import com.kyoulho.booksAroundMe.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/searchBook")
    public void searchBook(SearchRequestDTO searchRequestDTO, Model model) {
        SearchResultDTO result = bookService.searchBook(searchRequestDTO);
        model.addAttribute("result",result);
    }

    @GetMapping("/detailBook")
    public void detailBook() {

    }

}
