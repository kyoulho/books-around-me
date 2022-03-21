package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.api.SearchApi;
import com.kyoulho.booksAroundMe.dto.BookDTO;
import com.kyoulho.booksAroundMe.dto.SearchResultDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private SearchApi searchAPI;

    @Override
    public SearchResultDTO searchBook(String keyword, int page) {
        String jsonString = searchAPI.getBooksData(keyword, page);
        JSONObject jsonObject = new JSONObject(jsonString);

        JSONArray items = jsonObject.getJSONArray("items");
        int totalCount = (int) jsonObject.get("total");
        List<BookDTO> list = new ArrayList<>();

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

            BookDTO bookDTO = BookDTO.builder().isbn(isbn).title(title).author(author).imageSrc(imageSrc).price(price).publisher(publisher)
                    .build();

            list.add(bookDTO);
        }
        return SearchResultDTO.builder().totalCount(totalCount).list(list).build();
    }
}
