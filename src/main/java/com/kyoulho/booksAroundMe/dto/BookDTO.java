package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String author;
    private String imageSrc;
    private String price;
    private String publisher;

}
