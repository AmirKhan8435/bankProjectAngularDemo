package com.project.bank.service;

import java.util.List;

import com.project.bank.entity.Account;

public interface AccountSevices {

	public List<Account> getAll();
	
	public Account getAccountById(int account_id);
	
	public Account addAccount(Account acc);
	
	public int updateAccountByID(int Account_id, String Branch_Name, char Account_type, double Account_balance);
	
	public int DeleteByACCID(int account_id);
	
	public List<Account> getAccountByUserID(int userID);
	
	
}
