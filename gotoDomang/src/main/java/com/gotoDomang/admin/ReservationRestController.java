package com.gotoDomang.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoDomang.booking.bo.BookingBO;

@RestController
public class ReservationRestController {
	
	
	@Autowired
	private BookingBO bookingBO;
	
	@DeleteMapping("/reservation/booking/delete")
	public Map<String, Object> delete(
			@RequestParam("bookingId") int bookingId) {
		
		
		bookingBO.deleteBooking(bookingId);
		
	
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
}
