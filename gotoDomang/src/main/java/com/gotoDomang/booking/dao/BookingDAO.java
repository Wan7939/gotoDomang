package com.gotoDomang.booking.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gotoDomang.booking.model.Booking;

@Repository
public interface BookingDAO {
	public List<Booking> selectBookingList();
	
	public List<Booking> selectBookingListByUserId(int userId);
	
	public int insertBooking(
			@Param("userId") int userId
			,@Param("hotelId") int hotelId
			,@Param("name") String name
			, @Param("date") String date
			, @Param("day") int day
			, @Param("headcount") int headcount
			, @Param("phoneNumber") String phoneNumber
			, @Param("state") String state);
	
	public Booking selectHotel(int id);
	
	public int deleteBooking(int id);
}
