package com.kyoulho.booksaroundme.crawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
public class KyoboCrawlerTest {

    @Autowired
    private KyoboCrawler kyoboCrawler;

    @Test
    public void getStockDataTest() {
        String isbnDummy = "9788947544085";
        Map<String, String> result = kyoboCrawler.getStockData(isbnDummy);
        System.out.println(result);

    }
}

