package com.project.bank.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Account")
public class Account {
//	-- Account_id -- Numeric(10) double
//	-- User_ID -- foreign key
//	-- Branch_name -- 40 chars
//	-- Account_type -- (S-savings/C-current) 1 
//	-- Account_balance -- numeric (10,2)

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int Account_id;

	@Column
	private String Branch_Name;

	@Column
	private char Account_type;

	@Column
	private double Account_balance;

//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "User_ID",nullable = false)
	private User user;

	public Account() {

	}

	public Account(int account_id, String branch_Name, char account_type, double account_balance) {
		super();
		Account_id = account_id;
		Branch_Name = branch_Name;
		Account_type = account_type;
		Account_balance = account_balance;
	}

	public int getAccount_id() {
		return Account_id;
	}

	public void setAccount_id(int account_id) {
		Account_id = account_id;
	}

	public String getBranch_Name() {
		return Branch_Name;
	}

	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}

	public char getAccount_type() {
		return Account_type;
	}

	public void setAccount_type(char account_type) {
		Account_type = account_type;
	}

	public double getAccount_balance() {
		return Account_balance;
	}

	public void setAccount_balance(double account_balance) {
		Account_balance = account_balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Account [Account_id=" + Account_id + ", Branch_Name=" + Branch_Name + ", Account_type=" + Account_type
				+ ", Account_balance=" + Account_balance + "]";
	}

}