package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.BookDTO;

import java.util.List;
import java.util.Map;

public interface BookService {
    Map<String, Object> searchBook(String keyword, int page);
}
