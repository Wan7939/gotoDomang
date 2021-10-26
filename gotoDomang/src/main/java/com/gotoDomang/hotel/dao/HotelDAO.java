package com.gotoDomang.hotel.dao;



import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gotoDomang.hotel.model.Hotel;


@Repository
public interface HotelDAO {
	// @Param("hotelName") String  hotelName,
	
	public List<Hotel> selectPostList();
	
	public int insertHotel(
			@Param("hotelName") String  hotelName,
			@Param("location") String  location,
			@Param("price")  int price,
			@Param("hotelNumber") String hotelNumber,
			@Param("content") String content,
			@Param("imagePath") String imagePath);
}
