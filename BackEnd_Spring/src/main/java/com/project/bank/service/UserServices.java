package com.project.bank.service;

import java.util.Date;
import java.util.List;

import com.project.bank.entity.User;

public interface UserServices 
{
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User save(User u);
	
	public int updateUserByID(int User_ID, String Name, String Email_ID, String Mobile_number,Date date);
	
	public int deleteUser(int User_ID);
	
	public User logInCheck(User user);
	
}
