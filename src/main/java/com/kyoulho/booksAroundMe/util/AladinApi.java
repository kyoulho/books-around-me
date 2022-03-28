package com.kyoulho.booksAroundMe.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class AladinApi implements Api {
    private static final String TTB_KEY = "ttbwelturn1101001";
    private static final String BOOK_URL = " https://www.aladin.co.kr/ttb/api/ItemOffStoreList.aspx?ttbkey=[TTBKey]&itemIdType=ISBN13&ItemId=[도서의ISBN]&output=js";

    public String getStockJson(final String isbn) {
        String requestUrl = BOOK_URL.replace("[TTBKey]", TTB_KEY).replace("[도서의ISBN]", isbn);

        return getData(requestUrl);
    }

    private String getData(String requestUrl) {
        HttpURLConnection con = connect(requestUrl);
        try {
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return readbody(con.getInputStream());
            }else {
                return readbody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

}
