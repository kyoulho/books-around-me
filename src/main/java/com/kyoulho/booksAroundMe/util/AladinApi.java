package com.kyoulho.booksAroundMe.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class AladinApi implements Api {
    @Value("${aladin.ttb_key}")
    private String TTB_KEY;
    @Value("${aladin.book_url}")
    private String BOOK_URL;

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
            } else {
                return readbody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

}
