package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.StoreDTO;
import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;
import com.kyoulho.booksAroundMe.entity.Store;
import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import com.kyoulho.booksAroundMe.util.StockCrawler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StockCrawler stockCrawler;
    private final StoreMapper storeMapper;


    @Override
    public StoreResponseDTO getStoreStockData(final String isbn, final double latitude, final double longitude) {
        List<StoreDTO> _list = stockCrawler.getStoreStockList(isbn);

        List<StoreDTO> list = _list.stream().filter(dto -> dto.getStock() > 0)
                .peek(dto -> {
                    String storeName = "%" + dto.getStoreName() + "%";
                    Store entity = storeMapper.selectStore(storeName, latitude, longitude);
                    if (entity != null && entity.getDistance() <= 20) {
                        dto.setData(entity);
                    }
                }).filter(dto -> dto.getDistance() != 0).sorted((o1, o2) -> {
                    if (o1.getDistance() > o2.getDistance()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }).limit(10).collect(Collectors.toList());

        return StoreResponseDTO.builder().list(list).build();
    }
}
