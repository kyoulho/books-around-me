package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequestDTO {
    private int page;
    private int size;
    private String keyword;


    public BookRequestDTO(String keyword, int page) {
        this.keyword = keyword;
        this.page = page;
        this.size = 10;
    }
}
