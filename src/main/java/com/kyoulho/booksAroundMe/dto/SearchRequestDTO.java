package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchRequestDTO {
    private int page;
    private int size;
    private String keyword;


    public SearchRequestDTO(String keyword, int page){
        this.keyword = keyword;
        this.page = page;
        this.size = 10;
    }
}
