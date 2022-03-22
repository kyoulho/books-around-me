package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.SearchRequestDTO;
import com.kyoulho.booksAroundMe.dto.SearchResultDTO;

public interface BookService {
    SearchResultDTO searchBook(SearchRequestDTO searchRequestDTO);
}
