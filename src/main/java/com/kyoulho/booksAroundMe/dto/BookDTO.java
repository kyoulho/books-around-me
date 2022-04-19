package com.kyoulho.booksAroundMe.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDTO {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String imageSrc;
    private String price;
    private String publisher;

}
