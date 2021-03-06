package com.gotoDomang.review;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;
import com.gotoDomang.review.bo.ReviewBO;
import com.gotoDomang.review.model.Review;


@RequestMapping("/user")
@Controller
public class ReviewController {

	@Autowired
	private HotelBO hotelBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 요청 URL: http://localhost/user/review_view
			@RequestMapping("/review_view")
			public String reviewView(
					@RequestParam("hotelId") int hotelId,  // hotelId로 그id에있는 값들을 받아오기.
					
					Model model) {
				Hotel hotel = hotelBO.getHotel(hotelId);
				List<Review> reviewList = reviewBO.getReviewList(hotelId);
				model.addAttribute("reviewList", reviewList);
				model.addAttribute("viewName", "review/review_create");
				model.addAttribute("hotel", hotel);
	
				return "template/layout";
			}
			

}
