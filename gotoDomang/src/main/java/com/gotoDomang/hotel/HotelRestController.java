package com.gotoDomang.hotel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gotoDomang.hotel.bo.HotelBO;

@RestController
public class HotelRestController {
	
	@Autowired
	private HotelBO hotelBO;
	
	@RequestMapping("/post/registration")
	public Map<String, Object> create(
			@RequestParam("hotelName") String hotelName,
			@RequestParam("location") String location,
			@RequestParam("price") int price,
			@RequestParam("hotelNumber") String hotelNumber,
			@RequestParam("content") String content,
			@RequestParam("imagePath") MultipartFile file){
		
		Map<String, Object> result = new HashMap<>();
		
		int row = hotelBO.insertHotel(hotelName, location, price, hotelNumber, content, file);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}
		return result;
		
		
	}
	
	@DeleteMapping("/hotel/delete")
	public Map<String, Object> delete(
			@RequestParam("hotelId") int hotelId) {
		
		
		hotelBO.deleteHotel(hotelId);
		
	
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
	
}
