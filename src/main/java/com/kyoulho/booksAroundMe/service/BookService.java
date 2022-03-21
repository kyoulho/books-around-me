package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.SearchResultDTO;

public interface BookService {
    SearchResultDTO searchBook(String keyword, int page);
}
