package com.gotoDomang.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	// 요청 URL: http://localhost/hotel/registration
	@RequestMapping("/hotel/registration")
	public String hotelRegistrationView(Model model) {
		model.addAttribute("viewName", "admin/hotel_registration");
		return "template_admin/layout_admin";
	}

}
