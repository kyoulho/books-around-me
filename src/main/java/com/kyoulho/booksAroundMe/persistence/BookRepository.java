package com.kyoulho.booksAroundMe.persistence;

import com.kyoulho.booksAroundMe.entity.BookEntity;

import java.util.List;

public interface BookRepository {
    public List<BookEntity> getBookEntityList(String keyword,int page);
    public int getBookTotal(String keyword);
}
