package com.gotoDomang.booking;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class BookingController {
	
	// 요청 URL: http://localhost/user/insert_reservation
		@RequestMapping("/insert_reservation")
		public String signinView(Model model) {
			model.addAttribute("viewName", "reservation/insert_reservation");
			return "template/layout";
		}
}
