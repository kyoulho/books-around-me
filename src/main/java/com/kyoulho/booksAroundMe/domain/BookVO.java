package com.kyoulho.booksAroundMe.domain;

import lombok.Data;

@Data
public class BookVO {
    private String title;
    private String author;
    private String imageSrc;
    private String price;
    private String publisher;
    private String isbn;
}
