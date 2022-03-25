package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.StoreRequestDTO;
import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;

public interface StoreService {
    public StoreResponseDTO getStoreStockData(String isbn, double latitude, double longitude);
}
