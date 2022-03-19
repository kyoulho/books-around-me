package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.domain.BookVO;

import java.util.List;

public interface BookService {

    public List<BookVO> searchBook(String keyword);

}
