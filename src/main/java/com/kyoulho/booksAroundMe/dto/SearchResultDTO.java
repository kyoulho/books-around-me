package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SearchResultDTO {
    private int totalCount;
    private List<BookDTO> list;
}
