package com.project.bank.dao;




import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.bank.customException.CustomException;
import com.project.bank.entity.User;
import com.project.bank.repository.AccountRepository;
import com.project.bank.repository.UserRepository;
import com.project.bank.service.UserServices;



@Transactional
@Service
public class UserDao implements UserServices
{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AccountRepository accRepo;
	

	public List<User> getAllUsers() {
		if(userRepo.findAll().isEmpty())
			throw new CustomException(HttpStatus.NOT_FOUND,"List is Empty!!");
		else
			return userRepo.findAll();
	}

	public User getUserById(int id) {
		User u = userRepo.findById(id).get();
//		if(u.equals(null))
//			throw new NoSuchElementException();
		
		return u;
	}

	public User save(User u) {
		if(u.getName().isEmpty() || u.getName().length()==0)
			throw new CustomException(HttpStatus.BAD_REQUEST, "Input Field is Empty/Incomplete!!");
		else
		{
			System.out.println(u.getDOB());
			return userRepo.save(u);
		}
		
	}

	public int updateUserByID(int User_ID, String Name, String Email_ID, String Mobile_number,Date date) {
		if(User_ID==0 || Name.isEmpty() || Email_ID.isEmpty() || Mobile_number.isEmpty() || date.equals(null))
			throw new CustomException(HttpStatus.NOT_FOUND,"Value Missing!! Check RequestBody!!");
		
		return userRepo.updateUserByID(User_ID, Name, Email_ID, Mobile_number, date);
	}

	public int deleteUser(int User_ID) {
		User u = userRepo.findById(User_ID).get();
		if(u.equals(null))
			throw new NoSuchElementException();
		else
		{ 
			accRepo.deleteAccByUserId(User_ID);
			return userRepo.deleteUserById(User_ID);
		}
		
	}
	
	public User logInCheck(User user)
    {
        if(user.getEmail_ID().isEmpty() && user.getPassword().isEmpty())
        throw new NoSuchElementException();
        else
        {
//            String encodedPwd=Base64.getEncoder().encodeToString(user.getPassword().getBytes());
//            user.setPassword(encodedPwd);
            //System.out.println(user.getEmail_ID()+" "+user.getPassword());
            User checkUser=userRepo.loginCredentialsCheck(user.getEmail_ID(), user.getPassword());

            if( checkUser!=null)
            {
                return checkUser;
            }
            else  
            return null;
        }
    }
	
	

}
