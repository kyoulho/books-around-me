package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.BookDTO;

import java.util.List;

public interface BookService {
    public List<BookDTO> getBookList(String keyword, int page);

    public int getBookTotal(String keyword);
}
