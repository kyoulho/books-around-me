package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.util.StockCrawlerImpl;
import com.kyoulho.booksAroundMe.dto.StoreDTO;
import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;
import com.kyoulho.booksAroundMe.entity.StoreEntity;
import com.kyoulho.booksAroundMe.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StockCrawlerImpl stockCrawlerImpl;
    private final StoreMapper storeMapper;

    @Override
    public StoreResponseDTO getStoreStockData(final String isbn, final double latitude, final double longitude) {
        List<StoreDTO> _list = stockCrawlerImpl.getStoreStockList(isbn);

        List<StoreDTO> list = _list.stream().filter(dto -> dto.getStock() > 0)
                .peek(dto -> {
                    String storeName = "%" + dto.getStoreName() + "%";
                    StoreEntity entity = storeMapper.selectStore(storeName, latitude, longitude);
                    if (entity != null && entity.getDistance() <= 20) {
                        dto.setData(entity);
                    }
                }).filter(dto -> dto.getDistance() != 0).sorted(new Comparator<StoreDTO>() {
                    @Override
                    public int compare(StoreDTO o1, StoreDTO o2) {
                        if (o1.getDistance() > o2.getDistance()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }).limit(10).collect(Collectors.toList());

        return StoreResponseDTO.builder().list(list).build();
    }
}
