package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SearchRequestDTO {
    private int page;
    private int size;
    private String keyword;

    public SearchRequestDTO(String keyword){
        this.keyword = keyword;
        this.page = 1;
        this.size = 10;
    }
    public SearchRequestDTO(String keyword, int page){
        this.keyword = keyword;
        this.page = page;
        this.size = 10;
    }
}
