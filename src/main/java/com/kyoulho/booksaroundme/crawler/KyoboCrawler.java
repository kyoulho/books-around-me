package com.kyoulho.booksaroundme.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

@Component
public class KyoboCrawler {
    private final String kyoboStockUrl = "https://www.kyobobook.co.kr/prom/2013/general/StoreStockTable.jsp?barcode=isbn&ejkgb=KOR";

    public Map<String, String> getStockData(String isbn) {
        String url = kyoboStockUrl.replace("isbn", isbn);
        Document document = getDocument(url);

        Map<String, String> map = new HashMap<>();
        String query = "body>table>tbody>tr";

        StringTokenizer storeNames = new StringTokenizer(document.select(query).select("th").text(), " ");
        StringTokenizer stockCounts = new StringTokenizer(document.select(query).select("td a").text(), " ");
        while (storeNames.hasMoreTokens()) {
            map.put(storeNames.nextToken(), stockCounts.nextToken());
        }
        return map;
    }

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다.",e);
        }
        return document;
    }
}