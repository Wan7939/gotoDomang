
package com.gotoDomang.booking;




import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gotoDomang.booking.bo.ContentBO;
import com.gotoDomang.booking.model.Content;






@RequestMapping("/user")
@Controller
public class BookingController {
	
	@Autowired		
	private ContentBO contentBO;
	
	
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
				Model model, HttpServletRequest request) 	{
			HttpSession session = request.getSession();
			Integer userId = (Integer) session.getAttribute("userId");
			if (userId == null) {
				// 세션에 id가 없으면 로그인하는 페이지로 이동(redirect)
				return "redirect:/user/sign_in_view";
			}
			List<Content> contentList = contentBO.getContentList(userId);
			model.addAttribute("viewName", "reservation/reservation_list");
			model.addAttribute("contentList", contentList);
			
			return "template/layout";
		}
}
