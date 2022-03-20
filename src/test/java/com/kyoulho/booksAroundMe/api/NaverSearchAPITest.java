package com.kyoulho.booksAroundMe.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class NaverSearchAPITest {
    @Autowired
    NaverSearchAPI naverSearchAPI;

    @Test
    public void test(){
       String result = naverSearchAPI.getBooksData("정주영",1 );
        System.out.println(result);
    }

}
