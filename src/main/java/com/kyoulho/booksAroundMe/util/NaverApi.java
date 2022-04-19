package com.kyoulho.booksAroundMe.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class NaverApi implements Api {

    private final String clientID;
    private final String clientSecret;
    private final String apiURL;

    public NaverApi(@Value("${naver.client_id}") String clientId, @Value("${naver.client_secret}") String clientSecret, @Value("${naver.api_url}") String apiURL) {
        this.clientID = clientId;
        this.clientSecret = clientSecret;
        this.apiURL = apiURL;
    }

    public String getJsonAddress(String storeName) {
        String query;
        String start = "1";
        query = URLEncoder.encode(storeName, StandardCharsets.UTF_8);
        String requestUrl = apiURL.replace("[searchType]", "local")
                .replace("[query]", query)
                .replace("[start]", start);
        return getData(requestUrl);
    }

    public String getJsonBookList(String keyword, int page) {
        String query;
        String start;
        query = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        start = (page - 1) * 10 + 1 + "";
        String requestUrl = apiURL.replace("[searchType]", "book")
                .replace("[query]", query)
                .replace("[start]", start);
        return getData(requestUrl);
    }

    public String getJsonBook(String isbn) {
        String query;
        String start = "1";
        query = URLEncoder.encode(isbn, StandardCharsets.UTF_8);
        String requestUrl = apiURL.replace("[searchType]", "book")
                .replace("[query]", query)
                .replace("[start]", start)
                + "?d_isbn=" + isbn;
        return getData(requestUrl);
    }

    private String getData(String requestUrl) {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", clientID);
        requestHeaders.put("X-Naver-Client-Secret", clientSecret);

        HttpURLConnection con = connect(requestUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }
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

