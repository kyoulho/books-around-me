package com.kyoulho.booksAroundMe.crawler;

import com.kyoulho.booksAroundMe.entity.StoreEntity;
import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
