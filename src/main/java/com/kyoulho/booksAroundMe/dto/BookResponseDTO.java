package com.kyoulho.booksAroundMe.dto;

import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class BookResponseDTO {
    private List<BookDTO> list;
    private String keyword;
    private int totalCount;
    private int totalPage;
    private int page;
    private int size;
    private boolean prev, next;
    private int start, end;
    private List<Integer> pageList;

    public BookResponseDTO(List<BookDTO> list, int totalCount) {
        this.list = list;
        this.totalCount = Math.min(totalCount, 1000);
    }

    public void makePageList(BookRequestDTO bookRequestDTO) {
        this.keyword = bookRequestDTO.getKeyword();
        this.page = bookRequestDTO.getPage();
        this.size = bookRequestDTO.getSize();
        this.totalPage = (int) Math.ceil(totalCount / 10.0);

        int tempEnd = (int) (Math.ceil(page / 10.0)) * 10;
        start = tempEnd - 9;
        prev = start > 1;
        end = Math.min(totalPage, tempEnd);
        next = end < totalPage;
        pageList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
    }
}
