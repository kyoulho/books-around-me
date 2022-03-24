package com.kyoulho.booksAroundMe.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StoreServiceTest {
    @Autowired
    private StoreService service;

    @Test
    public void listTest(){
        service.getStoreStockData("9791166815782");
    }
}
