package com.project.bank.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;




@DisplayName("UserEntityTest")
class UserTest {

	List<Account> al=new ArrayList<>();
	
	User u=new User();
	
	@Test
	void testGetName() {
		u.setName("Amir");
		String exp="Amir";
		  assertThat(exp).isEqualTo(u.getName());
	}

	@Test
	void testGetEmail_ID() {
		u.setEmail_ID("amirkhan1214@gmail.com");
		String exp="amirkhan1214@gmail.com";
		assertEquals(exp,u.getEmail_ID());
	}
		
	

	@Test
	void testGetPassword() {
		u.setPassword("Amir@1214");
		String exp="Amir@1214";
		assertThat(exp).isEqualTo(u.getPassword());
	}

	@Test
	void testGetMobile_number() {
		u.setMobile_number("8830595218");
		String exp="8830595218";
		assertThat(exp).isEqualTo(u.getMobile_number());
	}

	@Test
	void testGetGender() {
		u.setGender('M');
		char exp='M';
		assertThat(exp).isEqualTo(u.getGender());
		//assertThat(u.getGender()).withFailMessage("Gender not should be m/M or f/F");
	}

	@Test
	void testGetDOB() throws ParseException {
		Date d=new Date();
		String s="1997-11-14";
		
		 d= new Date(new SimpleDateFormat("yyyy-mm-dd").parse(s).getDate());
		 u.setDOB(d);
		 
		assertEquals(d, u.getDOB());	
	}

//	@Test
//	void testGetAccount() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetUser_ID() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetName() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetEmail_ID() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetPassword() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetMobile_number() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetSecondary_Mobile() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetGender() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetDOB() {
//		//fail("Not yet implemented");
//	}
//
//	@Test
//	void testSetAccount() {
//		//fail("Not yet implemented");
//	}
//	

}
