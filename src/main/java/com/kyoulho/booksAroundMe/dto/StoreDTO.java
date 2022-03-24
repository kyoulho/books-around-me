package com.kyoulho.booksAroundMe.dto;

import com.kyoulho.booksAroundMe.entity.StoreEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StoreDTO {
    private String storeName;
    private String address;
    private double latitude;
    private double longitude;
    private int stock;

    public void setData(StoreEntity entity){
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
    }

}
