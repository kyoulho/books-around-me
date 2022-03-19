package com.kyoulho.booksaroundme.service;

import com.kyoulho.booksaroundme.domain.BookVO;

import java.util.List;

public interface BookService {

    public List<BookVO> searchBook(String keyword);

}
