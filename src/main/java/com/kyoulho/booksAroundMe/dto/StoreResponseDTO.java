package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreResponseDTO {

    private String kakaoApiKey;

    private List<StoreDTO> list;

    private BookDTO bookDTO;
    private String keyword;
    private int page;
    private String latitude;
    private String longitude;

    public void setResponse(StoreRequestDTO requestDTO) {
        this.keyword = requestDTO.getKeyword();
        this.page = requestDTO.getPage();
        this.latitude = requestDTO.getLatitude();
        this.longitude = requestDTO.getLongitude();
    }
}
