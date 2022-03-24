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
    private List<StoreDTO> seoul;
    private List<StoreDTO> metropolitan;
    private List<StoreDTO> province;
    private BookDTO bookDTO;
    private String keyword;
    private int page;

}
