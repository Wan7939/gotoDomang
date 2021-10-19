package com.gotoDomang.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotoDomang.user.dao.UserDAO;
import com.gotoDomang.user.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	
	public boolean existLoginId(String loginId) {
		return userDAO.existLoginId(loginId);
		
	}
	
	public void insertUser(String loginId, String password, String name, String email,String phoneNumber) {
		userDAO.insertUser(loginId, password, name, email, phoneNumber);
	}
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
}
