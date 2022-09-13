package com.project.bank.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.project.bank.entity.User;
import com.project.bank.repository.UserRepository;

class UserControllerTest 
{
//	@MockBean
//	UserRepository urepo;
//	
//	@MockBean
//	User user;
//	
//	@Autowired
//	UserController uc;
//	
//	private User userforTest;
//	private List<User> list;
//	private ResponseEntity<User> responseEntity;
//	
//	public UserControllerTest() throws ParseException {
//		userforTest = new User(1,"amir", "amir@1214");
//
//		list=new ArrayList<>();
//		list.add(userforTest);
//		
//		responseEntity = ResponseEntity.status(HttpStatus.OK).body(userforTest);
//	}
//	
//
//	@Test
//	void testGetAllUsers() 
//	{
//		when(urepo.findAll()).thenReturn(Stream.of(userforTest).collect(Collectors.toList()));
//		
////		assertThat(responseEntity).isNotNull();
////		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
////		assertThat(list.size()).isEqualTo(1);
////		assertThat(responseEntity).isEqualTo(uc.getAllUsersList());
////		assertEquals(responseEntity, uc.getAllUsers());
//	}
//
//	@Test
//	void testGetUserById() 
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testAddUser() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testUpdateById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDeleteById() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testLogInCheck() {
//		fail("Not yet implemented");
//	}

}
