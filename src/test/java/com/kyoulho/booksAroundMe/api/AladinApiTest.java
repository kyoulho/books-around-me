package com.kyoulho.booksAroundMe.api;

import com.kyoulho.booksAroundMe.util.AladinApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AladinApiTest {
    @Autowired
    private AladinApi api;

    @Test
    public void urlTest(){
        System.out.println(api.getStockJson("9788995379493"));;
    }
}
