package com.gotoDomang.hotel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HotelController {

	// 요청 URL: http://localhost/hotel/list_view
		@RequestMapping("/hotel/list_view")
			public String hotel(Model model) {
				model.addAttribute("viewName", "hotel/hotel_list");
				return "template/layout";
			}
}

