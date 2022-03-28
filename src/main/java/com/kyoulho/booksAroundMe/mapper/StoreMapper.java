package com.kyoulho.booksAroundMe.mapper;

import com.kyoulho.booksAroundMe.entity.StoreEntity;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Select("SELECT * ,(" +
            "6371 * acos (" +
            "cos ( radians(latitude) )" +
            "* cos( radians(#{lat}) )" +
            "* cos( radians(#{lng}) - radians(longitude))" +
            "+ sin( radians(latitude) )" +
            "* sin( radians(#{lat}))" +
            ")" +
            ") AS distance" +
            " FROM store_tbl" +
            " WHERE storeName like #{storeName}")
    public StoreEntity selectStore(@Param("storeName") String storeName, @Param("lat") double latitude, @Param("lng") double longitude);

    @Select("SELECT * FROM store_tbl")
    public List<StoreEntity> selectAllStore();

    @Update("UPDATE store_tbl SET address = #{address} WHERE storeName like #{storeName}")
    public void setAddress(StoreEntity storeEntity);

    @Update("UPDATE store_tbl SET city = #{city} WHERE storeName like #{storeName}")
    public void setCity(StoreEntity storeEntity);
}
