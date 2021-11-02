package com.gotoDomang.review;

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
public class ReviewController {

	@Autowired
	private HotelBO hotelBO;
	
	// 요청 URL: http://localhost/user/review_view
			@RequestMapping("/review_view")
			public String signinView(
					@RequestParam("hotelId") int hotelId,
					Model model) {
				List<Hotel> hotelList = hotelBO.getHotelList();
				model.addAttribute("viewName", "review/review_create");
				model.addAttribute("hotelList", hotelList);
				return "template/layout";
			}
			

}