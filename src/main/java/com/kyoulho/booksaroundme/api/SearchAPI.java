package com.kyoulho.booksaroundme.api;

import com.kyoulho.booksaroundme.domain.BookVO;

import java.util.List;

public interface SearchAPI {
    public List<BookVO> getBooksList(String keyword);
}
