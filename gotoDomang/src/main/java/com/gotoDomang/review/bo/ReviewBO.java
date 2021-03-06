package com.gotoDomang.review.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoDomang.review.dao.ReviewDAO;
import com.gotoDomang.review.model.Review;

@Service
public class ReviewBO {
	
	@Autowired
	private ReviewDAO reviewDAO;
	
	public List<Review> getReviewList(int hotelId) {
		return reviewDAO.selectReviewList(hotelId);
	}
	
	public int createReview(int userId, int hotelId, double point, String review) {
		return reviewDAO.insertReivew(userId, hotelId, point, review);
	}
	
	public Review getReview(int id) {
		return reviewDAO.selectReview(id);
	}
	
	public int deleteReviwe(int id) {
		
		return reviewDAO.deleteReview(id);
			
		}
}
