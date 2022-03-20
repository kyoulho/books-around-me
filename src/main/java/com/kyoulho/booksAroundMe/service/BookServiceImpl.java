package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.entity.BookEntity;
import com.kyoulho.booksAroundMe.dto.BookDTO;
import com.kyoulho.booksAroundMe.persistence.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> searchBook(String keyword, int page) {
        List<BookEntity> bookEntityList = bookRepository.getBookEntityList(keyword,page);
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (BookEntity entity : bookEntityList) {
            BookDTO dto = new BookDTO(entity);
            bookDTOList.add(dto);
        }
        return bookDTOList;
    }
}
