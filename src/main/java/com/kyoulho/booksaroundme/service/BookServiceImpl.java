package com.kyoulho.booksaroundme.service;

import com.kyoulho.booksaroundme.api.SearchAPI;
import com.kyoulho.booksaroundme.domain.BookVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private SearchAPI searchAPI;

    @Override
    public List<BookVO> searchBook(String keyword) {
        return searchAPI.getBooksList(keyword);
    }
}
