package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.BookRequestDTO;
import com.kyoulho.booksAroundMe.dto.BookResultDTO;

public interface BookService {
    BookResultDTO searchBook(BookRequestDTO bookRequestDTO);
}
