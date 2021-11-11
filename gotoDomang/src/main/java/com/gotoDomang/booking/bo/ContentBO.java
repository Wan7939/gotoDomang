package com.gotoDomang.booking.bo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoDomang.booking.model.Booking;
import com.gotoDomang.booking.model.Content;
import com.gotoDomang.hotel.bo.HotelBO;
import com.gotoDomang.hotel.model.Hotel;

@Service
public class ContentBO {
	
	@Autowired
	private BookingBO bookingBO;
	
	@Autowired
	private HotelBO hotelBO;
	
	public List<Content> getContentList(Integer userId) {  // userId로 가져올 contentList를 만든다.
		List<Content> contentList = new ArrayList<>();  // 새로 contentList를 만듬.
		
		// Booking 목록
				List<Booking> bookingList = bookingBO.getBookingListByUserId(userId);  // content안에 bookingList를 userId로 가져올 list를 만듬.
				for (Booking booking : bookingList) {   // for문을 돌림 (한줄씩)
					Content content = new Content(); 
					content.setBooking(booking); // content안에 model_content에서 선언한 booking들을 가져옴.
					
					// Booking - hotel 목록
					Hotel hotel = hotelBO.getHotel(booking.getHotelId());  // hotel 정보를 가져와야하는데, 호텔들이 아닌 userId에 맞는
					                                                       // 호텔들 하나하나가 필요하기때문에 model_booking에 있는 
																		   // hotelId를 사용해서 가져옴
					content.setHotel(hotel);
					contentList.add(content);
				}
		
		
		return contentList;
	}
		
	
	public List<Content> getContentList() {  // userId로 가져올 contentList를 만든다.
		List<Content> contentList = new ArrayList<>();  // 새로 contentList를 만듬.
		
		// Booking 목록
				List<Booking> bookingList = bookingBO.getBookingList();  // content안에 bookingList를 userId로 가져올 list를 만듬.
				for (Booking booking : bookingList) {   // for문을 돌림 (한줄씩)
					Content content = new Content(); 
					content.setBooking(booking); // content안에 model_content에서 선언한 booking들을 가져옴.
					
					// Booking - hotel 목록
					Hotel hotel = hotelBO.getHotel(booking.getHotelId());  // hotel 정보를 가져와야하는데, 호텔들이 아닌 userId에 맞는
					                                                       // 호텔들 하나하나가 필요하기때문에 model_booking에 있는 
																		   // hotelId를 사용해서 가져옴
					content.setHotel(hotel);
					contentList.add(content);
				}
		
		
		return contentList;
	}
		
		
}
