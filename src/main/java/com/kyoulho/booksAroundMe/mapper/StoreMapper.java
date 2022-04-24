package com.kyoulho.booksAroundMe.mapper;

import com.kyoulho.booksAroundMe.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
    public Store selectStore(@Param("storeName") String storeName, @Param("lat") double latitude, @Param("lng") double longitude);

}
