package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.api.NaverApi;
import com.kyoulho.booksAroundMe.dto.*;
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
    public BookResponseDTO searchBook(String keyword, int page) {
        String jsonString = naverApi.getJsonBookList(keyword, page);
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
            String subTitle = "";
            if (title.contains("(")) {
                subTitle = title.substring(title.indexOf("("),title.lastIndexOf(")")+1);
                title = title.substring(0, title.indexOf("("));
            }
            String author = item.getString("author").replace("<b>", "").replace("</b>", "");
            String imageSrc = item.getString("image").replace("type=m1", "");
            String price = item.getString("price").replace("<b>", "").replace("</b>", "");
            String publisher = item.getString("publisher").replace("<b>", "").replace("</b>", "");

            BookDTO bookDTO = BookDTO.builder().isbn(isbn).title(title).subTitle(subTitle).author(author).imageSrc(imageSrc).price(price).publisher(publisher)
                    .build();

            list.add(bookDTO);
        }
        return new BookResponseDTO(list, totalCount);
    }

    @Override
    public BookDTO getBookDTO(String isbn) {
        final NaverApi naverApi = new NaverApi();
        String jsonString = naverApi.getJsonBook(isbn);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray items = jsonObject.getJSONArray("items");
        JSONObject item = items.getJSONObject(0);
        String title = item.getString("title");
        String subTitle = "";
        if (title.contains("(")) {
            subTitle = title.substring(title.indexOf("("),title.lastIndexOf(")")+1);
            title = title.substring(0, title.indexOf("("));
        }
        String author = item.getString("author");
        String imageSrc = item.getString("image").replace("type=m1", "");
        String price = item.getString("price");
        String publisher = item.getString("publisher");

        return BookDTO.builder().isbn(isbn).title(title).subTitle(subTitle).author(author).imageSrc(imageSrc).price(price).publisher(publisher)
                .build();
    }

}
