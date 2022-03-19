package com.kyoulho.booksaroundme.api;

import com.kyoulho.booksaroundme.domain.BookVO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NaverSearchAPI implements SearchAPI{
    private static final String CLIENT_ID = "jyHa96iNcbPZ07I2HCY0";
    private static final String CLIENT_SECRET = "6qCHcDzqu0";


    public List<BookVO> getBooksList(String keyword) {
        String jsonString = getBooksData(keyword);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray items = jsonObject.getJSONArray("items");
        List<BookVO> bookList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            BookVO bookVO = new BookVO();
            String isbn = item.getString("isbn");
            if (isbn.contains(" ")) {
                isbn = isbn.substring(isbn.indexOf(" ") + 1);
            }
            bookVO.setIsbn(isbn);

            String imageSrc = item.getString("image").replace("type=m1", "");
            bookVO.setImageSrc(imageSrc);

            bookVO.setPrice(item.getString("price"));
            bookVO.setPublisher(item.getString("publisher"));
            bookVO.setTitle(item.getString("title").replace("<b>", "").replace("</b>", ""));
            bookVO.setAuthor(item.getString("author").replace("<b>", "").replace("</b>", ""));
            bookList.add(bookVO);
        }
        return bookList;
    }


    private  String getBooksData(String keyword) {
        String query;
        query = URLEncoder.encode(keyword, StandardCharsets.UTF_8);

        String apiURL = "https://openapi.naver.com/v1/search/book.json?query=" + query;

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

        return getData(apiURL, requestHeaders);
    }

    private  String getData(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
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

    private  HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private  String readbody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }
            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

}
