package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.crawler.StockCrawlerImpl;
import com.kyoulho.booksAroundMe.dto.StoreDTO;
import com.kyoulho.booksAroundMe.dto.StoreRequestDTO;
import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;
import com.kyoulho.booksAroundMe.entity.StoreEntity;
import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StockCrawlerImpl stockCrawlerImpl;
    private final StoreMapper storeMapper;

    public StoreResponseDTO getStoreStockData(final String isbn) {
        List<StoreDTO> seoul = new ArrayList<>();
        List<StoreDTO> metropolitan = new ArrayList<>();
        List<StoreDTO> province = new ArrayList<>();
        List<StoreDTO> list = stockCrawlerImpl.getStoreStockList(isbn);
        for (StoreDTO dto : list) {
            if (dto.getStock() > 0) {
                String storeName = "%" + dto.getStoreName() + "%";
                StoreEntity entity = storeMapper.selectStore(storeName);
                dto.setData(entity);

                String address = dto.getAddress();
                if (address.contains("서울특별시")) {
                    seoul.add(dto);
                } else if (address.contains("경기도") || address.contains("인천광역시")) {
                    metropolitan.add(dto);
                } else {
                    province.add(dto);
                }
            }
        }
        return StoreResponseDTO.builder().seoul(seoul).metropolitan(metropolitan).province(province).build();
    }

}
