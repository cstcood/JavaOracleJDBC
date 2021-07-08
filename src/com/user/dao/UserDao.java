package com.user.dao;
import com.user.entity.User;

/**
 * @author 16409
 */
public interface UserDao {
	//the methods in interface are not having body
	/**
	 * login with userName and passWord
	 *
	 * @param userName the use's login name
	 * @param passWord password of login
	 * @return User
	 */
	User login(String userName, String passWord);
}
