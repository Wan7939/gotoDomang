package com.gotoDomang.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;

@Controller
public class PostController {

	@Autowired
	private HotelBO hotelBO;
	
	// 요청 URL: http://localhost/hotel/list_view
		@RequestMapping("/hotel/list_view")
			public String hotel(Model model) {
			List<Hotel> hotelList = hotelBO.getHotelList();
				model.addAttribute("viewName", "post/hotel_list");
				model.addAttribute("hotelList", hotelList);
				return "template/layout";
			}
}

