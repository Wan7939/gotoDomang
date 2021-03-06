package com.gotoDomang.review.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.gotoDomang.review.model.Review;

@Repository
public interface ReviewDAO {
	
	
	public List<Review> selectReviewList(int hotelId);
	
	public int insertReivew(
			@Param("userId") int userId, 
			@Param("hotelId") int hotelId,
			@Param("point") double point, 
			@Param("review") String review);
	
	public Review selectReview(int id);
	
	public int deleteReview(int id);
}
