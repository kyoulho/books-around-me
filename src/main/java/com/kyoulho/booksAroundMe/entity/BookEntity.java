package com.kyoulho.booksAroundMe.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookEntity {
    private String isbn;
    private String title;
    private String author;
    private String imageSrc;
    private String price;
    private String discount;
    private String publisher;
    private String link;
    private String description;
    private String pubDate;
}

