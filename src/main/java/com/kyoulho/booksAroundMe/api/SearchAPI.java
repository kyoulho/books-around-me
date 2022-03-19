package com.kyoulho.booksAroundMe.api;

import com.kyoulho.booksAroundMe.domain.BookVO;

import java.util.List;

public interface SearchAPI {
    public List<BookVO> getBooksList(String keyword);
}
