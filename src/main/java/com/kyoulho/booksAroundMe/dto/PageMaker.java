package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageMaker {
    private String keyword;
    private int page;
    private int totalCount;
    private int totalPageNum;
    private boolean prev;
    private boolean next;
    private int startPage;
    private int endPage;
    private int displayPageNum = 10;

    public void setTotalCount(int totalCount) {
        this.totalCount = Math.min(totalCount, 1000);
        calcData();

    }

    private void calcData() {
        totalPageNum = (int) Math.ceil(totalCount / 10d);
        endPage = (int) (Math.ceil(page / (double) displayPageNum) * displayPageNum);
        startPage = (endPage - displayPageNum) + 1;
        if (endPage > totalPageNum) {
            endPage = totalPageNum;
        }
        prev = startPage != 1;
        next = endPage == totalPageNum ? false : true;
    }
}
