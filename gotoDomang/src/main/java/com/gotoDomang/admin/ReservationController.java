package com.gotoDomang.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gotoDomang.booking.bo.BookingBO;
import com.gotoDomang.booking.model.Booking;
import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;

@Controller
public class ReservationController {
	
	@Autowired
	private BookingBO bookingBO;
	
	
	@Autowired
	private HotelBO hotelBO;
	/**
	 * 호텔 등록
	 * @param model
	 * @return
	 */
	// 요청 URL: http://localhost/reservation/manager_view
		@RequestMapping("/reservation/manager_view")
		public String managerView(Model model) {
			List<Booking> bookingList = bookingBO.getBookingList();
			model.addAttribute("viewName", "admin/reservation_view");
			model.addAttribute("bookingList", bookingList);
			return "template_admin/layout_admin";
		}
		
		// 요청 URL: http://localhost/hotel/manager_list
		@RequestMapping("/hotel/manager_list")
		public String reservationView(Model model) {
			List<Hotel> hotelList = hotelBO.getHotelList();
			model.addAttribute("viewName", "admin/hotel_manager_list");
			model.addAttribute("hotelList", hotelList);
			return "template_admin/layout_admin";
		}
}
