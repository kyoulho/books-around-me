package com.kyoulho.booksAroundMe.dto;

import com.kyoulho.booksAroundMe.entity.BookEntity;
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

    public BookDTO(final BookEntity entity) {
        this.isbn = entity.getIsbn();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.imageSrc = entity.getImageSrc();
        this.price = entity.getPrice();
        this.publisher = entity.getPublisher();
    }
}
