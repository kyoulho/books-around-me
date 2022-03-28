package com.kyoulho.booksAroundMe.crawler;

import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import com.kyoulho.booksAroundMe.util.StockCrawlerImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockCrawlerTest {
    @Autowired
    private StockCrawlerImpl stockCrawler;

    @Autowired
    private StoreMapper mapper;

    @Test
    public void test() {
        System.out.println(stockCrawler.getStoreStockList("9791186757093"));
    }

}
