package com.kyoulho.booksAroundMe.entity;

import lombok.Data;

@Data
public class StoreEntity {
    private String storeName;
    private String city;
    private String address;
    private double latitude;
    private double longitude;

}
