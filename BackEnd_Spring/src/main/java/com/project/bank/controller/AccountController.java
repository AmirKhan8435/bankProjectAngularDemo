package com.project.bank.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bank.dao.AccountDao;
import com.project.bank.dto.AccountDTO;
import com.project.bank.entity.Account;
import com.project.bank.entity.User;
import com.project.bank.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountDao accountService;

	@Autowired
	private UserRepository userRepo;
	
	
	@GetMapping("/getAllAccounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> listOfAllAccounts = accountService.getAll();
		return new ResponseEntity<List<Account>>(listOfAllAccounts, HttpStatus.OK);
	}

	@GetMapping("/getaccount/{id}")
	public ResponseEntity<Account> getAccountByAccountId(@PathVariable int id) {
		Account accountFound = accountService.getAccountById(id);
		return new ResponseEntity<Account>(accountFound, HttpStatus.OK);
	}
	
	@PostMapping("/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody AccountDTO acc) {
		System.out.println("inside account controller "+acc.getUser_ID());	
		User user1 = userRepo.findById(acc.getUser_ID()).get();
		System.out.println(user1);
		Account account = new Account(acc.getAccount_id(),acc.getBranch_Name(),acc.getAccount_type(),acc.getAccount_balance());
		account.setUser(user1);
		Account accountSave = accountService.addAccount(account);
		System.out.println(account);
		return new ResponseEntity<Account>(accountSave, HttpStatus.CREATED);
	}

	@GetMapping("/userid/{id}")
	public ResponseEntity<List<Account>> getAccountByUserID(@PathVariable int id) {
		System.out.println("inside account controller getuserbyid : "+id);
		List<Account> listOfAllAccounts = accountService.getAccountByUserID(id);
		return new ResponseEntity<List<Account>>(listOfAllAccounts, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccount/{id}")
	public ResponseEntity<Void> deleteAccountById(@PathVariable("id") int Useraccount_id_ID) {
		accountService.DeleteByACCID(Useraccount_id_ID);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/updateAccount")
	public ResponseEntity<Account> UpdateAccountById( @RequestBody Account acc) //@Valid 
	{

		int noOfChanges = accountService.updateAccountByID(acc.getAccount_id(), acc.getBranch_Name(),
				acc.getAccount_type(), acc.getAccount_balance());
		System.out.println("noOfChanges:" + noOfChanges);
		Account accountSave = accountService.getAccountById(acc.getAccount_id());
		return new ResponseEntity<Account>(accountSave, HttpStatus.CREATED);
	}

}
