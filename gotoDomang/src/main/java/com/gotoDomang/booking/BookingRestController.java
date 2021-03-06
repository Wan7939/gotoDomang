package com.gotoDomang.booking;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoDomang.booking.bo.BookingBO;

@RestController
public class BookingRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookingBO bookingBO;
	
	@PostMapping("/insert_reservation")
	public Map<String, Object> insertBooking(
			@RequestParam("hotelId") int hotelId
			,@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("result", "error");
			logger.error("[댓글쓰기] 로그인 세션이 없습니다.");
			return result;
		}
		
		int row = bookingBO.insertBooking(userId,hotelId, name, date, day, headcount, phoneNumber);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			logger.error("[예약하기] 예약하기 중 실패하였습니다.");
		}
		return result;
	}
	
	@DeleteMapping("/user/booking/delete")
	public Map<String, Object> delete(
			@RequestParam("bookingId") int bookingId) {
		
		
		bookingBO.deleteBooking(bookingId);
		
	
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		
		return result;
	}
}
	


