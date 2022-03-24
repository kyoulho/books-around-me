package com.kyoulho.booksAroundMe.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void getBookDTOTEST(){
        System.out.println(bookService.getBookDTO("9788972773412"));
    }
}
