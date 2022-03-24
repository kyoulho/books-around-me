package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.StoreResponseDTO;

public interface StoreService {
    public StoreResponseDTO getStoreStockData(final String isbn);
}
