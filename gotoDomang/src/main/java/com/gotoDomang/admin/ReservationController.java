package com.gotoDomang.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {
	
	// 요청 URL: http://localhost/reservation/manager_view
		@RequestMapping("/reservation/manager_view")
		public String managerView(Model model) {
			model.addAttribute("viewName", "admin/reservation_view");
			return "template_admin/layout_admin";
		}
}
