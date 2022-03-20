package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.BookDTO;

import java.util.List;

public interface BookService {

    public List<BookDTO> searchBook(String keyword,int page);

}
