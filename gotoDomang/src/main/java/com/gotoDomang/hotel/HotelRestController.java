package com.gotoDomang.hotel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class HotelRestController {
	
	@RequestMapping("/post/registration")
	public Map<String, Object> create(
			@RequestParam("hotelName") String hotelName,
			@RequestParam("location") String location,
			@RequestParam("price") int price,
			@RequestParam("hotelNumber") String hotelNumber,
			@RequestParam("content") String content,
			@RequestParam("imagePath") MultipartFile imagePath){
		
		
		return"";
	}
			
}
