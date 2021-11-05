package com.gotoDomang.booking;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;






@RequestMapping("/user")
@Controller
public class BookingController {
	
	
	
	@Autowired
	private HotelBO hotelBO;
	
	
	// 요청 URL: http://localhost/user/insert_reservation
		@RequestMapping("/insert_reservation")
		public String reservationView(
				@RequestParam("hotelId") int hotelId,
				Model model) 	{
			model.addAttribute("hotelId", hotelId);
			model.addAttribute("viewName", "reservation/insert_reservation");
			return "template/layout";
		}
		
		// 요청 URL: http://localhost/user/reservation_list
		@RequestMapping("/reservation_list")
		public String reservationListView(
				Model model) 	{
			List<Hotel> hotelList = hotelBO.getHotelList();
			model.addAttribute("viewName", "reservation/reservation_list");
			model.addAttribute("hotelList", hotelList);
			
			return "template/layout";
		}
}
