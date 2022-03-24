package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.BookRequestDTO;
import com.kyoulho.booksAroundMe.dto.BookResultDTO;
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
    public void searchBook(BookRequestDTO bookRequestDTO, Model model) {
        BookResultDTO result = bookService.searchBook(bookRequestDTO);
        model.addAttribute("result",result);
    }

    @GetMapping("/whichBook")
    public void whichBook(Model model) {

    }

}
