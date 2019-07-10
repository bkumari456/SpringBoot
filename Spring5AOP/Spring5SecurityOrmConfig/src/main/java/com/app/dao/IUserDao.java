package com.app.dao;

import com.app.model.User;

public interface IUserDao {

	void saveUser(User user);
	User findByUserEmail(String username);

}
