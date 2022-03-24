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
     // 나중을 위해 남겨둘 것
    @Test
    public void setDBAddress() {
        List<StoreEntity> list = mapper.selectAllStore();
        for (StoreEntity entity : list) {
            String storeName = entity.getStoreName();
            String address = stockCrawler.getAddress(storeName);
            entity.setAddress(address);
            mapper.setAddress(entity);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //나중을 위해 남겨 둘 것
    @Test
    public void setDBCity() {
        List<StoreEntity> list = mapper.selectAllStore();
        for (StoreEntity entity : list) {
            String address = entity.getAddress();
            String city = address.substring(0, address.indexOf("시") + 1);
            entity.setCity(city);
            mapper.setCity(entity);
            System.out.println(entity.getStoreName());
        }
    }
}
