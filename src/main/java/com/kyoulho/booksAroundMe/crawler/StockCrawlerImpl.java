package com.kyoulho.booksAroundMe.crawler;

import com.kyoulho.booksAroundMe.api.AladinApi;
import com.kyoulho.booksAroundMe.api.NaverApi;
import com.kyoulho.booksAroundMe.dto.StoreDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

@Component
public class StockCrawlerImpl {
    @Autowired
    private NaverApi naverApi;

    public List<StoreDTO> getStoreStockList(final String isbn) {
        List<StoreDTO> StoreStockList = new ArrayList<>();
        StoreStockList.addAll(getKyoboStockData(isbn));
        StoreStockList.addAll(getAladinStockData(isbn));

        return StoreStockList;
    }

    // 네이버 검색 속도 제한으로 쓰레드 슬립을 사용할 것을 권장
    public String getAddress(String storeName) {
        String jsonString = naverApi.getJsonAddress(storeName);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("items");
        JSONObject storeObj = jsonArray.getJSONObject(0);
        return storeObj.getString("address");
    }


    private List<StoreDTO> getKyoboStockData(final String isbn) {
        String KYOBO_URL = "https://www.kyobobook.co.kr/prom/2013/general/StoreStockTable.jsp?barcode=isbn&ejkgb=KOR";
        String requestUrl = KYOBO_URL.replace("isbn", isbn);
        Document document = getDocument(requestUrl);

        List<StoreDTO> list = new ArrayList<>();
        String query = "body>table>tbody>tr";

        StringTokenizer storeNames = new StringTokenizer(document.select(query).select("th").text(), " ");
        StringTokenizer stockCounts = new StringTokenizer(document.select(query).select("td a").text(), " ");
        while (storeNames.hasMoreTokens()) {
            String storeName = "교보문고 " + storeNames.nextToken();
            int stock = Integer.parseInt(stockCounts.nextToken());
            StoreDTO dto = StoreDTO.builder().storeName(storeName).stock(stock).build();
            list.add(dto);
        }
        return list;
    }

    private List<StoreDTO> getAladinStockData(final String isbn) {
        AladinApi api = new AladinApi();
        String jsonString = api.getStockJson(isbn);
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray stores = jsonObject.getJSONArray("itemOffStoreList");
        List<StoreDTO> list = new ArrayList<>();
        for (int i = 0; i < stores.length(); i++) {
            JSONObject store = stores.getJSONObject(i);
            String storeName = "알라딘 " + store.getString("offName");
            String _link = store.getString("link");
            String link = _link.replace("amp;", "");

            Document document = getDocument(link);
            String _stock = document.select("#used-book > div.col.width7 > table > tbody > tr:nth-child(2) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr > td > div:nth-child(1) > ul > li:nth-child(2) > span > span.ss_p4").text();
            int stock = Integer.parseInt(_stock.substring(0, 1));
            StoreDTO dto = StoreDTO.builder().storeName(storeName).stock(stock).build();
            list.add(dto);
        }
        return list;
    }

    private Document getDocument(String url) {
        Document document = null;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다.", e);
        }
        return document;
    }

}