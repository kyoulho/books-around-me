package com.kyoulho.booksAroundMe.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;

@Component
public class AladinApi implements Api {
    @Value("${aladin.ttb_key}")
    private  String ttbKey;
    @Value("${aladin.book_url}")
    private  String bookURL;


    public String getStockJson(String isbn) {
        String requestUrl = bookURL.replace("[TTBKey]", ttbKey).replace("[ISBN]", isbn);
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
