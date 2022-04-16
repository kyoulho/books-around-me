package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.*;
import com.kyoulho.booksAroundMe.service.BookService;
import com.kyoulho.booksAroundMe.service.StoreService;
import lombok.Getter;
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
    private final StoreService storeService;

    @GetMapping("/searchBook")
    public void searchBook(BookRequestDTO bookRequestDTO, Model model) {
        String keyword = bookRequestDTO.getKeyword();
        int page = bookRequestDTO.getPage();

        BookResponseDTO result = bookService.searchBook(keyword, page);

        result.makePageList(bookRequestDTO);

        model.addAttribute("result", result);
    }

    @GetMapping("/whichBook")
    public void whichBook(StoreRequestDTO storeRequestDTO, Model model) {
        String isbn = storeRequestDTO.getIsbn();
        BookDTO bookDTO = bookService.getBookDTO(isbn);

        double latitude = Double.parseDouble(storeRequestDTO.getLatitude());
        double longitude = Double.parseDouble(storeRequestDTO.getLongitude());


        StoreResponseDTO result = storeService.getStoreStockData(isbn, latitude, longitude);
        result.setBookDTO(bookDTO);
        result.setResponse(storeRequestDTO);

        model.addAttribute("result", result);
    }

}
