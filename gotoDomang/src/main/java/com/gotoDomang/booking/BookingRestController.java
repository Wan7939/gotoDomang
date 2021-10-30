package com.gotoDomang.booking;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoDomang.booking.bo.BookingBO;

@RestController
public class BookingRestController {
	
	@Autowired
	private BookingBO bookingBO;
	
	@PostMapping("/insert_reservation")
	public Map<String, String> insertBooking(
			@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		
		bookingBO.insertBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
}