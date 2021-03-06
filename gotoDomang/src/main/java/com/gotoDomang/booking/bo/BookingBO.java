package com.gotoDomang.booking.bo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoDomang.booking.dao.BookingDAO;
import com.gotoDomang.booking.model.Booking;



@Service
public class BookingBO {

	@Autowired
	private BookingDAO bookingDAO;
	
	
	
	public List<Booking> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	public List<Booking> getBookingListByUserId(int userId) {
		return bookingDAO.selectBookingListByUserId(userId);
	}
	
	public Booking getBooking(int hotelId) {
		return bookingDAO.selectHotel(hotelId);
	}
	
	public int insertBooking(
			int userId
			,int hotelId
			,String name
			,String date
			,int day
			,int headcount
			,String phoneNumber) {
		
		return bookingDAO.insertBooking(userId,hotelId, name, date, day, headcount, phoneNumber, "대기중");
	}
	
public int deleteBooking(int id) {
		
	return bookingDAO.deleteBooking(id);
		
	}

}
