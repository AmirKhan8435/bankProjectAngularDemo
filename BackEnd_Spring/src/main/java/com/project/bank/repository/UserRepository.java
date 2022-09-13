package com.project.bank.repository;





import java.util.Date;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bank.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Modifying
	@Query(value = " update user set Name=?2,Email_ID=?3,Mobile_number=?4,DOB=?5 where User_ID=?1 ", nativeQuery = true)
	public int updateUserByID(int User_ID, String Name, String Email_ID, String mobile_number, Date DOB);

	@Modifying
	@Query(value = " delete from user where User_ID=?1", nativeQuery = true)
	public int deleteUserById(int User_ID);
	
	@Query(value=" select * from user where email_id=?1 && password=?2",nativeQuery = true)
    public User loginCredentialsCheck(String Email_ID, String Password);

}
