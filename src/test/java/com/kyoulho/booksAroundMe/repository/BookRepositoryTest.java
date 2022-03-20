package com.kyoulho.booksAroundMe.repository;

import com.kyoulho.booksAroundMe.persistence.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    public void totalTest(){
        System.out.println(bookRepository.getBookTotal("정주영"));
    }

    @Test
    public void pageTest(){
        System.out.println(bookRepository.getBookEntityList("정주영",2));
    }
}
