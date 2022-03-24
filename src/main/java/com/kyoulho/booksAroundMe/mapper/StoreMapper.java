package com.kyoulho.booksAroundMe.mapper;

import com.kyoulho.booksAroundMe.dto.StoreDTO;
import com.kyoulho.booksAroundMe.entity.StoreEntity;
import org.apache.catalina.Store;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StoreMapper {
    @Select("SELECT * FROM store_tbl WHERE storeName like #{storeName}")
    public StoreEntity selectStore(@Param("storeName") String storeName);

    @Select("SELECT * FROM store_tbl")
    public List<StoreEntity> selectAllStore();

    @Update("UPDATE store_tbl SET address = #{address} WHERE storeName like #{storeName}")
    public void setAddress(StoreEntity storeEntity);

    @Update("UPDATE store_tbl SET city = #{city} WHERE storeName like #{storeName}")
    public void setCity(StoreEntity storeEntity);
}
