package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.api.NaverApi;
import com.kyoulho.booksAroundMe.dto.BookDTO;
import com.kyoulho.booksAroundMe.dto.BookRequestDTO;
import com.kyoulho.booksAroundMe.dto.BookResultDTO;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final NaverApi naverApi;

    @Override
    public BookResultDTO searchBook(BookRequestDTO bookRequestDTO) {
        String jsonString = naverApi.getBookJson(bookRequestDTO.getKeyword(), bookRequestDTO.getPage());
        JSONObject jsonObject = new JSONObject(jsonString);

        int totalCount = (int) jsonObject.get("total");

        JSONArray items = jsonObject.getJSONArray("items");
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
        return new BookResultDTO(list, totalCount, bookRequestDTO);
    }
}
