package com.kyoulho.booksAroundMe.service;

import com.fasterxml.jackson.core.JsonFactory;
import com.kyoulho.booksAroundMe.api.NaverApi;
import com.kyoulho.booksAroundMe.crawler.StockCrawlerImpl;
import com.kyoulho.booksAroundMe.dto.StoreDTO;
import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StockCrawlerImpl stockCrawlerImpl;
    private final NaverApi naverApi;

    // 네이버 검색 속도 제한.... 데이터 베이스에 주소 다 담아야겠다 힝구....
    public StoreResponseDTO getStoreStockData(final String isbn) {
        List<StoreDTO> list = stockCrawlerImpl.getStoreStockList(isbn);
//        for (StoreDTO dto : list) {
//            String storeName = dto.getStoreName();
//            System.out.println(storeName);
//            String jsonString = naverApi.getAddressJson(storeName);
//            JSONObject jsonObject = new JSONObject(jsonString);
//            JSONArray jsonArray =  jsonObject.getJSONArray("items");
//            JSONObject store = jsonArray.getJSONObject(0);
//            System.out.println(store);
//        }
        return null;
    }


}
