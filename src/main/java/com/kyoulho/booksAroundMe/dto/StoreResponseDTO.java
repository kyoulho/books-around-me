package com.kyoulho.booksAroundMe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreResponseDTO {
    private List<StoreDTO> seoul;
    private List<StoreDTO> metropolitan;
    private List<StoreDTO> province;
    private String bookTitle;
    private String bookIsbn;

}
