package com.project.bank.dao;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.project.bank.entity.User;
import com.project.bank.repository.UserRepository;




@SpringBootTest
class UserDaoTest 
{
	@Autowired
	UserDao userDao;

	@MockBean
	UserRepository urepo;

	private User userforTest;
//	private User userforTest1;
	private Optional<User> userforTestOptional;
//	private Optional<User> userforTestOptional1;
	
	public UserDaoTest() throws ParseException 
	{

		userforTest = new User(1,"amir", "amir@1214");
		
//		userforTest1 = new User(1,"amir","amir123@gmail.com", "amir@1214",
//								"8830595218", "9421876170", "1997-11-14", 'M', null);
		
		
		
		userforTestOptional=Optional.of(new User(1,"amir", "amir@1214"));
		
//		userforTestOptional1=Optional.of(new User(1,"amir","amir123@gmail.com", "amir@1214",
//										"8830595218", "9421876170", "1997-11-14", 'M', null));
		
	}
	
	
	
	@Test
	@Order(1)
	void testGetAllUsers() 
	{
		urepo.save(userforTest);
		when(urepo.findAll()).thenReturn(Stream.of(new User(1,"amir", "amir@1214"),new User(1,"sameer", "sameer@123")).collect(Collectors.toList()));
		assertEquals(2, userDao.getAllUsers().size());
	}

	@Test
	@Order(2)
	void testGetUserById() 
	{
		when(urepo.findById(1)).thenReturn(userforTestOptional);
		assertEquals(userforTest.toString(), userDao.getUserById(1).toString());
	}

	@Test
	@Order(3)
	void testSave() 
	{
		when(urepo.save(userforTest)).thenReturn(userforTest);
		assertEquals(userforTest, userDao.save(userforTest));
	}
	
	@Test
	@Order(4)
	void testDeleteUser() 
	{
		when(urepo.findById(1)).thenReturn(userforTestOptional);
		assertEquals(userforTestOptional, urepo.findById(1));
//		userDao.deleteUser(1);
//		verify(urepo,times(1)).deleteById(1);
		when(urepo.deleteUserById(1)).thenReturn(1);
		userDao.deleteUser(1);
		assertEquals(1, userDao.deleteUser(1));
	}

	@Test
	@Order(5)
	void testUpdateUserByID() throws Exception 
	{
		User uUpdated = new User(1,"amir","amir123@gmail.com","amir@1214","0000011111",new Date(new SimpleDateFormat("yyyy-mm-dd").parse("1997-11-14").getDate()));
		
		Optional<User> uUpdatedOpt = Optional.of(new User(1,"amir","amir123@gmail.com","amir@1214","0000011111",new Date(new SimpleDateFormat("yyyy-mm-dd").parse("1997-11-14").getDate())));
		
		when(urepo.findById(1)).thenReturn(uUpdatedOpt);
		assertEquals(uUpdatedOpt, urepo.findById(1));
		
		when(urepo.updateUserByID(1, uUpdated.getName(), uUpdated.getEmail_ID(), uUpdated.getMobile_number(), uUpdated.getDOB())).thenReturn(1);
		assertEquals(1, userDao.updateUserByID(1, uUpdated.getName(), uUpdated.getEmail_ID(), uUpdated.getMobile_number(), uUpdated.getDOB()));
		
	}

	@Test
	@Order(6)
	void testLogInCheck() throws ParseException 
	{
		User u = new User(1,"amir","amir123@gmail.com","amir@1214","0000011111",new Date(new SimpleDateFormat("yyyy-mm-dd").parse("1997-11-14").getDate()));
//		String encodedPwd=Base64.getEncoder().encodeToString(u.getPassword().getBytes());
//		u.setPassword(encodedPwd);
		userforTest = new User(1,"amir","amir123@gmail.com","amir@1214","0000011111",new Date(new SimpleDateFormat("yyyy-mm-dd").parse("1997-11-14").getDate()));
		when(urepo.loginCredentialsCheck(u.getEmail_ID(), u.getPassword())).thenReturn(u);
		assertEquals(u, userDao.logInCheck(userforTest));
	}

}
