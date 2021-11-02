package com.gotoDomang.booking;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoDomang.booking.bo.BookingBO;
import com.gotoDomang.booking.model.Booking;


@RequestMapping("/user")
@Controller
public class BookingController {
	
	@Autowired
	private BookingBO bookingBO;
	

	
	// 요청 URL: http://localhost/user/insert_reservation
		@RequestMapping("/insert_reservation")
		public String reservationView(
				@RequestParam("hotelId") int hotelId,
				Model model) 	{
		
			Booking booking = bookingBO.getBooking(hotelId);
			model.addAttribute("reservation", booking);
			model.addAttribute("viewName", "reservation/insert_reservation");
			return "template/layout";
		}
}
