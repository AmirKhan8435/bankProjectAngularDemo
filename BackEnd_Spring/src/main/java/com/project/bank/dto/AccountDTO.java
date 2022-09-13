package com.project.bank.dto;

public class AccountDTO 
{
	private int account_id;
	private String branch_Name;
	private char account_type;
	private double account_balance;
	private int user_ID;
	
	public AccountDTO() {}

	public AccountDTO(int account_id, String branch_Name, char account_type, double account_balance, int user_ID) {
		super();
		this.account_id = account_id;
		this.branch_Name = branch_Name;
		this.account_type = account_type;
		this.account_balance = account_balance;
		this.user_ID = user_ID;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getBranch_Name() {
		return branch_Name;
	}

	public void setBranch_Name(String branch_Name) {
		this.branch_Name = branch_Name;
	}

	public char getAccount_type() {
		return account_type;
	}

	public void setAccount_type(char account_type) {
		this.account_type = account_type;
	}

	public double getAccount_balance() {
		return account_balance;
	}

	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}

	public int getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	@Override
	public String toString() {
		return "AccountDTO [account_id=" + account_id + ", branch_Name=" + branch_Name + ", account_type="
				+ account_type + ", account_balance=" + account_balance + ", user_ID=" + user_ID + "]";
	}
	
		
	
		
}
