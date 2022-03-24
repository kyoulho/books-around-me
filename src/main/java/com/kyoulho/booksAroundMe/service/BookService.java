package com.kyoulho.booksAroundMe.service;

import com.kyoulho.booksAroundMe.dto.*;

public interface BookService {
    BookResponseDTO searchBook(String keyword, int page);

    BookDTO getBookDTO(String isbn);


}
