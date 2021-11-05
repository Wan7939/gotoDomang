package com.gotoDomang.review;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gotoDomang.review.bo.ReviewBO;

@RestController
public class ReviewRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ReviewBO reviewbo;
	
	@RequestMapping("/review/create")
	public Map<String, Object> create(
			@RequestParam("hotelId") int hotelId,
			@RequestParam("review") String review,
			@RequestParam("point") double point,
			HttpServletRequest request) {
		
		Map<String, Object> result = new HashMap<>();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");
		if (userId == null) {
			result.put("result", "error");
			logger.error("[후기등록] 로그인 세션이 없습니다.");
			return result;
		}
		
		int row = reviewbo.createReview(userId, hotelId, point, review);
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
			logger.error("[후기등록] 후기등록 중 실패하였습니다.");
		}
		return result;
		}
}
