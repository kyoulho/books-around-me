package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.api.SearchAPI;
import com.kyoulho.booksAroundMe.domain.BookVO;
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
