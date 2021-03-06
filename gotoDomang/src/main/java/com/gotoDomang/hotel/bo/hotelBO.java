package com.gotoDomang.hotel.bo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gotoDomang.common.FileManagerService;
import com.gotoDomang.hotel.dao.HotelDAO;
import com.gotoDomang.hotel.model.Hotel;



@Service
public class HotelBO {
	
	private Logger logger = LoggerFactory.getLogger(HotelBO.class);
	
	@Autowired
	private HotelDAO hotelDAO;
	
	@Autowired
	private FileManagerService fileManagerService;
	
	public List<Hotel> getHotelList() {
		return hotelDAO.selectHotelList();
	}
	
	
	
	public Hotel getHotel(int id) {
		return hotelDAO.selectHotel(id);
	}
	
	public List<Hotel> getHotelListByType(String type) {
		if (type.equals("lowPrice")) {
			return hotelDAO.selectHotelListByLowPrice(type);
		}else if (type.equals("highPrice")) {
			return hotelDAO.selectHotelListByHighPrice(type);
		}
//		else if (type.equals("lowPoint")) {
//			return hotelDAO.selectHotelListByLowPoint(type);
//		}else if (type.equals("highPoint")) {
//			return hotelDAO.selectHotelListByHighPoint(type);
//		}
		return new ArrayList<>();
					
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
	
	
	public void deleteHotel(int hotelId) {
		
		Hotel hotel = hotelDAO.selectHotel(hotelId);
		if (hotel == null) {
			logger.warn("[글 삭제] 이미 삭제되었습니다.");
			return;
		}
		
		// post 삭제
		hotelDAO.deleteHotel(hotelId);
	
		// image 삭제
		String imagePath = hotel.getImagePath();
		if (imagePath != null) {
			try {
				fileManagerService.deleteFile(imagePath);
			} catch (IOException e) {
				logger.warn("[삭제에 실패했습니다.] " + imagePath);
			}
		}
	}
}
