package com.kyoulho.booksAroundMe.api;

import com.kyoulho.booksAroundMe.util.AladinApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class AladinApiTest {
    @Autowired
    private AladinApi aladinApi;

    @Test
    public void connectTest(){
        // given
        String isbn13 = "9788995379493";

        // when
        String json = aladinApi.getStockJson(isbn13);

        // then
        assertThat(json).contains("itemOffStoreList");
    }
}
