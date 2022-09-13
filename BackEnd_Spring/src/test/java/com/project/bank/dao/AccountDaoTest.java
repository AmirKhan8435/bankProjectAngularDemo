package com.project.bank.dao;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.constraints.Pattern;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.project.bank.entity.Account;
import com.project.bank.entity.User;
import com.project.bank.repository.AccountRepository;
import com.project.bank.repository.UserRepository;






@SpringBootTest	
@TestMethodOrder(OrderAnnotation.class)
@DisplayName("AccountServiceImpl Test")
class AccountDaoTest 
{
	
	@Autowired
	AccountDao accDao;

	@Autowired
	UserDao userDao;

	@MockBean
	AccountRepository arepo;

	@MockBean
	UserRepository urepo;

	private Account accountforTest;
	private Optional<Account> accountforTestOptional;
	private User userforTest;
	
	public AccountDaoTest() throws ParseException 
	{
		accountforTest = new Account(1000000,"HDFC_bank",'S',55000);
		
		accountforTestOptional=Optional.of(new Account(1000000,"HDFC_bank",'S',55000));
		
		userforTest = new User(1,"amir","amir123@gmail.com","amir@1214","0000011111",new Date(new SimpleDateFormat("yyyy-mm-dd").parse("1997-11-14").getDate()));
	}
	
	
	
	@Test
	@Order(1)
	void testGetAll() 
	{
		List<Account> al = new ArrayList<>();
		al.add(accountforTest);
		when(arepo.findAll()).thenReturn(al);
		assertEquals(1, accDao.getAll().size());
	}
	
	@Test
	@Order(2)
	void testGetAccountById() 
	{
		when(arepo.findById(1000000)).thenReturn(accountforTestOptional);
		assertEquals(accountforTest.toString(), accDao.getAccountById(1000000).toString());
	}

	@Test
	@Order(3)
	void testAddAccount()
	{
		accountforTest.setUser(userforTest);
		Optional<User> userforTestOptional=Optional.of(userforTest);
		when(urepo.findById(1)).thenReturn( userforTestOptional);
		assertEquals(userforTest, userDao.getUserById(1));

		when(arepo.save(accountforTest)).thenReturn(accountforTest);
		assertThat(accDao.addAccount(accountforTest)).isEqualTo(accountforTest);
	}
	
	@Test
	@Order(4)
	void testGetAccountsByUserId() {
		when(arepo.getAccountByUserID(1000000)).thenReturn(Stream.of(new Account(1000000,
				"HDFC_bank",'S',55000)).collect(Collectors.toList()));
		assertEquals(1, accDao.getAccountByUserID(1000000).size());
	}
	
	@Test
	@Order(5)
	void testUpdateAccount() 
	{
		accountforTest.setAccount_balance(99999);
		accountforTest.setUser(userforTest);
		//long account_id,String branch_Name, char account_type, double account_balance, User user);
		when(arepo.updateAccountByID(1000000,"HDFC_bank",'S',99999)).thenReturn(1);
		assertEquals(1, accDao.updateAccountByID(accountforTest.getAccount_id(), accountforTest.getBranch_Name(), accountforTest.getAccount_type(), accountforTest.getAccount_balance()));

	}
	
	@Test
	@Order(6)
	void testDeleteAccountById() 
	{
		when(arepo.findById(1000000)).thenReturn(accountforTestOptional);
		assertEquals(accountforTest.toString(),arepo.findById(1000000).get().toString());
		
//		when(urepo.findById(1)).thenReturn(userforTestOptional);
//		assertEquals(userforTestOptional, urepo.findById(1));
		
//		when(urepo.deleteUserById(1)).thenReturn(1);
//		userDao.deleteUser(1);
//		assertEquals(1, userDao.deleteUser(1));
		
		
		when(arepo.deleteACCById(1000000)).thenReturn(1);
		accDao.DeleteByACCID(1000000);
		assertEquals(1, accDao.DeleteByACCID(1000000));

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
