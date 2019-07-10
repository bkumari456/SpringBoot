package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao dao;
	
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	@Transactional(readOnly=true)
	public User findUserByEmail(String email) {
		return dao.findByUserEmail(email);
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		user.setUserPwd(bCryptPasswordEncoder.encode(user.getUserPwd()));
       	dao.saveUser(user);
	}

}
