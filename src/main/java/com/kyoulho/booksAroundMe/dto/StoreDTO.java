package com.kyoulho.booksAroundMe.dto;

import com.kyoulho.booksAroundMe.entity.Store;
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
    private double distance;

    private int stock;

    public void setData(Store entity) {
        this.address = entity.getAddress();
        this.latitude = entity.getLatitude();
        this.longitude = entity.getLongitude();
        this.distance = entity.getDistance();
    }

}
