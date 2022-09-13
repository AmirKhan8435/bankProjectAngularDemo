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
import com.project.bank.dao.UserDao;
import com.project.bank.entity.User;
import com.project.bank.repository.AccountRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userService;


	@GetMapping("/getAllUsers")
	public ResponseEntity<List<com.project.bank.entity.User>> getAllUsers() {
		List<User> listOfAllUsers = userService.getAllUsers();
		return new ResponseEntity<List<User>>(listOfAllUsers, HttpStatus.OK);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		User userFound = userService.getUserById(id);
		return new ResponseEntity<User>(userFound, HttpStatus.OK);
	}

	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User u)  //@Valid
	{
		User userSave = userService.save(u);
		System.out.println(u.getDOB());
		return new ResponseEntity<User>(userSave, HttpStatus.CREATED);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<User> UpdateById( @RequestBody User u)  //@Valid
	{
		int noOfChanges = userService.updateUserByID(u.getUser_ID(), u.getName(), u.getEmail_ID(), u.getMobile_number(),
				u.getDOB());
		System.out.println("noOfChanges:" + noOfChanges);
		User userSave = userService.getUserById(u.getUser_ID());
		return new ResponseEntity<User>(userSave, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id) {
		userService.deleteUser(id);
		
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/loginCheck")
    public ResponseEntity<?> logInCheck(@RequestBody User user)
    {
        if( !(user.getEmail_ID().isEmpty() && user.getPassword().isEmpty()) )
        {
        	System.out.println(user);
            User u = userService.logInCheck(user);
            return new ResponseEntity<User>(u,HttpStatus.ACCEPTED);
        }
        else
        return new ResponseEntity<String>("No User found",HttpStatus.NOT_ACCEPTABLE);
        	
    }
	
	

}
