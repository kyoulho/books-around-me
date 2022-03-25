package com.kyoulho.booksAroundMe.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreRequestDTO {
    private String keyword;
    private int page;
    private String isbn;
    private String latitude;
    private String longitude;
}
