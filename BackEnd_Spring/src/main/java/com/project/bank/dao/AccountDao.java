package com.project.bank.dao;


import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.bank.customException.CustomException;
import com.project.bank.dto.AccountDTO;
import com.project.bank.entity.Account;
import com.project.bank.entity.User;
import com.project.bank.repository.AccountRepository;
import com.project.bank.repository.UserRepository;
import com.project.bank.service.AccountSevices;



@Transactional
@Service
public class AccountDao implements AccountSevices
{

	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private UserRepository userRepo;

	public List<Account> getAll() {
		if(accountRepo.findAll().isEmpty())
			throw new CustomException(HttpStatus.NOT_FOUND,"List is Empty!!");
		
		return accountRepo.findAll();
	}

	public Account getAccountById(int account_id) {		
		Account acc = accountRepo.findById(account_id).get();
		if(acc.equals(null))
			throw new NoSuchElementException();
		
		return acc;
	}

	public Account addAccount(Account acc) {

//		if(acc.getAccount_balance()==0 || acc.getAccount_type()==0 || acc.getBranch_Name().equals(null) )
//			throw new CustomException(HttpStatus.BAD_REQUEST, "Input Field is Empty/Incomplete!!");
		
//		User u = userRepo.findById(acc.getUser()).get();
//		
//		System.out.println(u);
//		
//		Account account = new Account(acc.getAccount_id(),acc.getBranch_Name(),acc.getAccount_type(),acc.getAccount_balance());
//		account.setUser(u);
//		
//		System.out.println(account);
		
		Account accSave = accountRepo.save(acc);

		return accSave;
	}

	public int updateAccountByID(int Account_id, String Branch_Name, char Account_type, double Account_balance) {
		if(Account_id==0 || Account_balance==0 || Account_type==0 || Branch_Name.equals(null) )
			throw new CustomException(HttpStatus.BAD_REQUEST, "Input Field is Empty/Incomplete!!");
		
		return accountRepo.updateAccountByID(Account_id, Branch_Name, Account_type, Account_balance);
	}

	public int DeleteByACCID(int account_id) {
		
		Account acc = accountRepo.findById(account_id).get();
		if(acc.equals(null))
			throw new NoSuchElementException();
		else
		{
			return accountRepo.deleteACCById(account_id);
		}
			
			
	}

	public List<Account> getAccountByUserID(int userID) 
	{
		List<Account> account = accountRepo.getAccountByUserID(userID);
		if(account.size() == 0)
			throw new NoSuchElementException();
		
		System.out.println(account);
		return account;
	}
	

}
