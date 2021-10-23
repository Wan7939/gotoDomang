package com.gotoDomang.hotel.dao;



import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;


@Repository
public interface HotelDAO {
	// @Param("hotelName") String  hotelName,
	public int insertHotel(
			@Param("hotelName") String  hotelName,
			@Param("location") String  location,
			@Param("price")  int price,
			@Param("hotelNumber") String hotelNumber,
			@Param("content") String content,
			@Param("imagePath") MultipartFile imagePath);
}
