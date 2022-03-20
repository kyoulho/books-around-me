package com.kyoulho.booksAroundMe.persistence;

import com.kyoulho.booksAroundMe.entity.BookEntity;
import com.kyoulho.booksAroundMe.api.SearchAPI;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Autowired
    private SearchAPI searchAPI;

    @Override
    public List<BookEntity> getBookEntityList(String keyword, int page) {

        String jsonString = searchAPI.getBooksData(keyword, page);
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray items = jsonObject.getJSONArray("items");
        List<BookEntity> bookEntityList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            String isbn = item.getString("isbn");
            if (isbn.contains(" ")) {
                isbn = isbn.substring(isbn.indexOf(" ") + 1);
            }
            String title = item.getString("title").replace("<b>", "").replace("</b>", "");
            String author = item.getString("author").replace("<b>", "").replace("</b>", "");
            String imageSrc = item.getString("image").replace("type=m1", "");
            String price = item.getString("author").replace("<b>", "").replace("</b>", "");
            String publisher = item.getString("publisher");
            String discount = item.getString("discount");
            String description = item.getString("description");
            String pubDate = item.getString("pubdate");
            String link = item.getString("link");

            BookEntity bookEntity = BookEntity.builder().isbn(isbn).title(title).author(author).imageSrc(imageSrc).price(price).publisher(publisher).build();

            bookEntityList.add(bookEntity);
        }
        return bookEntityList;
    }
}
