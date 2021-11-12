package com.gotoDomang.post;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;

@Controller
public class PostController {

	@Autowired
	private HotelBO hotelBO;
	
	// 요청 URL: http://localhost/hotel/list_view
		@RequestMapping("/hotel/list_view")
			public String hotel(
					@RequestParam(value="type", required=false) String type,
					Model model,  HttpServletRequest request) {
			HttpSession session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			if (userId == null) {
				// 세션에 id가 없으면 로그인하는 페이지로 이동(redirect)
				return "redirect:/user/sign_in_view";
			}
			
			if (type == null) {
				List<Hotel> hotelList = hotelBO.getHotelList();
				model.addAttribute("viewName", "post/hotel_list");
				model.addAttribute("hotelList", hotelList);
				return "template/layout";
			}
			List<Hotel> hotelList = hotelBO.getHotelListByType(type);
				model.addAttribute("viewName", "post/hotel_list");
				model.addAttribute("hotelList", hotelList);
				return "template/layout";
			}
		
		
}

