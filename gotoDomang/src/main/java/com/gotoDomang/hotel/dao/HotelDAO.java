package com.gotoDomang.hotel.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gotoDomang.hotel.model.Hotel;

@Repository
public interface HotelDAO {
	
	public List<Hotel> selectPostList();
}
