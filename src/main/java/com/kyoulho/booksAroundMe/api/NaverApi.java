package com.kyoulho.booksAroundMe.api;

import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class NaverApi implements Api {
    private static final String CLIENT_ID = "jyHa96iNcbPZ07I2HCY0";
    private static final String CLIENT_SECRET = "6qCHcDzqu0";
    private static final String API_URL = "https://openapi.naver.com/v1/search/[searchType].json?query=[query]&start=[start]";

    public String getAddressJson(String storeName){
        String query;
        String start = "1";
        query = URLEncoder.encode(storeName, StandardCharsets.UTF_8);
        String requestUrl = API_URL.replace("[searchType]","local").replace("[query]", query).replace("[start]", start);
        return getData(requestUrl);
    }

    public String getBookJson(String keyword, int page) {
        String query;
        String start;
        query = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        start = (page - 1) * 10 + 1 + "";
        String requestUrl = API_URL.replace("[searchType]","book").replace("[query]", query).replace("[start]", start);
        return getData(requestUrl);
    }

    private String getData(String requestUrl) {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

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

