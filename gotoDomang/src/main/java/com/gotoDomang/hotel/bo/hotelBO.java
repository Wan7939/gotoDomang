package com.gotoDomang.hotel.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gotoDomang.hotel.dao.HotelDAO;



@Service
public class HotelBO {
	
	@Autowired
	private HotelDAO hotelDAO;
	
	public int insertHotel(String hotelName, String location,
			int price, String hotelNumber, String content,
			MultipartFile imagePath) {
		return hotelDAO.insertHotel(hotelName, location, price, hotelNumber, content, imagePath);
	}
}
