package com.kyoulho.booksaroundme.Util;

import com.kyoulho.booksaroundme.domain.BookVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class NaverSearchAPITest {
    @Autowired
    NaverSearchAPI naverSearchAPI;

    @Test
    public void test(){
        List<BookVO> list = naverSearchAPI.getBooksList("정주영");
        System.out.println(list);
    }
}
