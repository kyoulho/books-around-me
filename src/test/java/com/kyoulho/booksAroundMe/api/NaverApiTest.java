package com.kyoulho.booksAroundMe.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NaverApiTest {
    @Autowired
    NaverApi naverApi;

    @Test
    public void getBookListTest(){
       String result = naverApi.getJsonBookList("정주영",1 );
        System.out.println(result);
    }
    @Test
    public void localTest(){
        String result = naverApi.getJsonAddress("알라딘_건대점");
        System.out.println(result);
    }

    @Test
    public void getBookTest(){
        System.out.println(naverApi.getJsonBook("9791166815782"));

    }
}
