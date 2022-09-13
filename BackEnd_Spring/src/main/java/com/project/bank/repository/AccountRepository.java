package com.project.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.bank.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Modifying
	@Query(value = " delete from account where Account_id =?1", nativeQuery = true)
	public int deleteACCById(int Account_id);
	
	@Modifying
	@Query(value = " update Account set Branch_Name=?2,Account_type=?3,Account_balance=?4 where Account_id=?1 ", nativeQuery = true)
	public int updateAccountByID(int Account_id, String Branch_Name, char Account_type, double Account_balance);

	@Modifying
	@Query(value = " select * from account where user_id=?1", nativeQuery = true)
	public List<Account> getAccountByUserID(int userID);
	
	
	@Modifying
	@Query(value = " delete from account where user_id =?1", nativeQuery = true)
	public int deleteAccByUserId(int user_id);

}
