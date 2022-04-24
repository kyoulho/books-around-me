package com.kyoulho.booksAroundMe.api;

import com.kyoulho.booksAroundMe.util.NaverApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class NaverApiTest {
    @Autowired
    NaverApi naverApi;

    @Test
    public void getBookListTest() {
        String keyword = "정주영";
        int page = 1;
        String json = naverApi.getJsonBookList(keyword, page);
        assertThat(json).contains(keyword, String.valueOf(page));
    }

    @Test
    public void searchStoreTest() {
        // given
        String storeName = "알라딘중고서점 건대점";
        // when
        String json = naverApi.getJsonAddress(storeName);
        // then
        assertThat(json).contains(storeName);
    }

    @Test
    public void searchBookTest() {
        // given
        String isbn13 = "9791166815782";

        // when
        String json = naverApi.getJsonBook(isbn13);

        //then
        assertThat(json).contains(isbn13);

    }
}
