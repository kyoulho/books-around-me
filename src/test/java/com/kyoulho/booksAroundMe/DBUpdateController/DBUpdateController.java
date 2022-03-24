package com.kyoulho.booksAroundMe.DBUpdateController;

import com.kyoulho.booksAroundMe.crawler.StockCrawlerImpl;
import com.kyoulho.booksAroundMe.entity.StoreEntity;
import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DBUpdateController {
    @Autowired
    private StockCrawlerImpl stockCrawler;
    @Autowired
    private StoreMapper mapper;

    @Test
    public void setDatabase() {
        List<StoreEntity> list = mapper.selectAllStore();
        for (StoreEntity entity : list) {
            String storeName = entity.getStoreName();
            String address = stockCrawler.getAddress(storeName);
            entity.setAddress(address);
            mapper.setCity(entity);
            mapper.setAddress(entity);
            System.out.println(storeName+ " 업데이트 완료");
        }
    }


}
