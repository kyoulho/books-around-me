package com.kyoulho.booksAroundMe.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SearchApiNaverTest {
    @Autowired
    SearchApiNaver searchAPINaver;

    @Test
    public void test(){
       String result = searchAPINaver.getBooksData("정주영",1 );
        System.out.println(result);
    }

}
