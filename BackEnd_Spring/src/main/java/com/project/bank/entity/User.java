package com.project.bank.entity;



import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "User")
public class User {

//	-- User_ID -- Primary Key -- numeric(5)
//	-- Name   -- 40 Chars
//	-- Email_ID   -- 100 cars
//	-- Mobile number -- 10 char
//	-- Secondary _Mobile -- 10 char
//	-- DOB --String format"DD-MMM-YYYY"
//	-- Gender -- (M/F) -- single Char

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int User_ID;

	@Column
	private String Name;

	@Email(message = "Invalid Email Address!!")
	@NotBlank(message = "Invalid Email Address!!")
	@Column(unique = true)
	private String Email_ID;

	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Mobile Number!!")
	private String Mobile_number;

	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Secondary Number!!")
	private String Secondary_Mobile;

	@Column
	private char Gender;

	@Column
	@Temporal(TemporalType.DATE)
	private Date DOB;
	
	@Column
	@NotNull(message = "Password cann't be empty!!!")
//	@Size(min = 5 , max = 15 , message = "Enter password of length 5 to 15")
	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Account> accounts;

	public User() {
		this.accounts = new ArrayList<>();
	}

	public User(int User_ID) {
		this.User_ID = User_ID;
	}
	
	public User(int User_ID,String name,String password) 
	{
		this.User_ID = User_ID;
		this.Name = name;
		this.password = password;
	}
	
	
	
	public User(int User_ID,String name,String email ,String password , String mobile ,Date dob) 
	{
		this.User_ID = User_ID;
		this.Name = name;
		this.Email_ID = email;
		this.Mobile_number = mobile;
		this.password = password;
		this.DOB = dob;
	}
	

	public User(int user_ID, String name, @Email String email_ID, @Pattern(regexp = "^[0-9]{10}$") String mobile_number,
			@Pattern(regexp = "^[0-9]{10}$") String secondary_Mobile, char gender, String DOB) throws ParseException {
		
		User_ID = user_ID;
		Name = name;
		Email_ID = email_ID;
		Mobile_number = mobile_number;
		Secondary_Mobile = secondary_Mobile;
		Gender = gender;
		this.DOB = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(DOB).getDate());
	}
	
	public User(int user_ID, String name, @Email String email_ID, @Pattern(regexp = "^[0-9]{10}$") String mobile_number,
			@Pattern(regexp = "^[0-9]{10}$") String secondary_Mobile, String pwd, String string2, char gender, String DOB) throws ParseException {
		
		User_ID = user_ID;
		Name = name;
		Email_ID = email_ID;
		Mobile_number = mobile_number;
		Secondary_Mobile = secondary_Mobile;
		password = pwd;
		Gender = gender;
		this.DOB = new Date(new SimpleDateFormat("yyyy-mm-dd").parse(DOB).getDate());
	}
	
	
	
	public User(int user_ID, String name,
			@Email(message = "Invalid Email Address!!") @NotBlank(message = "Invalid Email Address!!") String email_ID,
			@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Mobile Number!!") String mobile_number,
			@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Secondary Number!!") String secondary_Mobile,
			char gender, Date dOB, @NotNull(message = "Password cann't be empty!!!") String password,
			List<Account> accounts) {
		
		User_ID = user_ID;
		Name = name;
		Email_ID = email_ID;
		Mobile_number = mobile_number;
		Secondary_Mobile = secondary_Mobile;
		Gender = gender;
		DOB = dOB;
		this.password = password;
		this.accounts = accounts;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public int getUser_ID() {
		return User_ID;
	}

	public void setUser_ID(int user_ID) {
		User_ID = user_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail_ID() {
		return Email_ID;
	}

	public void setEmail_ID(String email_ID) {
		Email_ID = email_ID;
	}

	public String getMobile_number() {
		return Mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		Mobile_number = mobile_number;
	}

	public String getSecondary_Mobile() {
		return Secondary_Mobile;
	}

	public void setSecondary_Mobile(String secondary_Mobile) {
		Secondary_Mobile = secondary_Mobile;
	}

	public char getGender() {
		return Gender;
	}

	public void setGender(char gender) {
		Gender = gender;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "User [User_ID=" + User_ID + ", Name=" + Name + ", Email_ID=" + Email_ID + ", Mobile_number="
				+ Mobile_number + ", Secondary_Mobile=" + Secondary_Mobile + ", Gender=" + Gender + ", DOB=" + DOB
				+ ", password=" + password + ", accounts=" + accounts + "]";
	}

//	public void addAccount(Account acc)
//	{
//		this.accounts.add(acc);
//		acc.setUser(this);
//	}

	

}
