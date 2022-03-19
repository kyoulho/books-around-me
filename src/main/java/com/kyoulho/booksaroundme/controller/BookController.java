package com.kyoulho.booksaroundme.controller;

import com.kyoulho.booksaroundme.domain.BookVO;
import com.kyoulho.booksaroundme.Util.NaverSearchAPI;
import com.kyoulho.booksaroundme.crawler.KyoboCrawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private KyoboCrawler kyoboCrawler;
    @Autowired
    private NaverSearchAPI naverSearchAPI;

    @GetMapping("/searchBook")
    public void searchBook(String keyword, Model model) {
       List<BookVO> list = naverSearchAPI.getBooksList(keyword);
       model.addAttribute("keyword",keyword);
       model.addAttribute("list",list);

    }

}
