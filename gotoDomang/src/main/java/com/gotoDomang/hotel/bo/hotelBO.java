package com.gotoDomang.hotel.bo;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gotoDomang.common.FileManagerService;
import com.gotoDomang.hotel.dao.HotelDAO;
import com.gotoDomang.hotel.model.Hotel;



@Service
public class HotelBO {
	
	@Autowired
	private HotelDAO hotelDAO;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	public List<Hotel> getHotelList() {
		return hotelDAO.selectHotelList();
	}
		
		
	
	public int insertHotel(String hotelName, String location,
			int price, String hotelNumber, String content,
			MultipartFile file) {
		
		String imagePath = null;
		if (file != null) {
			try {
				imagePath = fileManagerService.saveFile(file);
			} catch (IOException e) {
				imagePath = null;
			}
		}
		return hotelDAO.insertHotel(hotelName, location, price, hotelNumber, content, imagePath);
	}
}
