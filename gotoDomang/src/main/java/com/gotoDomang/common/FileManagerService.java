package com.gotoDomang.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component  // 스프링 빈
public class FileManagerService {
	
	// WebMvcConfig도 같이 볼것 => 실제 저장된 파일과 이미지 패스릴 매핑해줌
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 실제 이미지가 저장될 경로					D:\박경완\7_spring_preject\gotoDomang_workspace\images
	public final static String FILE_UPLOAD_PATH = "D:\\박경완\\7_spring_preject\\gotoDomang_workspace\\images/";
	
	public String saveFile(MultipartFile file) throws IOException {
		//  파일 디렉토리 경로 예	: hotel_162099585780/apple.png
		//  파일명이 겹치지 않게 현재시간을 경로에 붙여준다.
		String directoryName = "hotel" + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			logger.error("[파일업로드] 디렉토리 생성 실패" + directoryName + ", filePath : " + filePath);
			return null;
		} 
		
		// 파일 업로드: byte 단위로 업로드 된다.
		byte[] bytes = file.getBytes();
		Path path = Paths.get(filePath + file.getOriginalFilename()); // input에 올린 파일명이다.
		Files.write(path, bytes);
		
		// 이미지 URL path를 리턴한다.
		// 예) http://localhost/images/hotel_1633346649040/dodo2.jpg
		return "/images/" + directoryName + file.getOriginalFilename();
	}
}