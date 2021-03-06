package com.kyoulho.booksAroundMe.controller;

import com.kyoulho.booksAroundMe.dto.*;
import com.kyoulho.booksAroundMe.service.BookService;
import com.kyoulho.booksAroundMe.service.StoreService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("book")
@Slf4j
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final StoreService storeService;
    @Value("${kakao.api_key}")
    private String kakaoApiKey;


    @GetMapping("/searchBook")
    public void searchBook(BookRequestDTO bookRequestDTO, Model model) {
        log.info("searchBook :" + bookRequestDTO);
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
        log.info("whichBook: "+ bookDTO);

        double latitude = Double.parseDouble(storeRequestDTO.getLatitude());
        double longitude = Double.parseDouble(storeRequestDTO.getLongitude());


        StoreResponseDTO result = storeService.getStoreStockData(isbn, latitude, longitude);
        result.setKakaoApiKey(kakaoApiKey);
        result.setBookDTO(bookDTO);
        result.setResponse(storeRequestDTO);

        model.addAttribute("result", result);
    }

}
