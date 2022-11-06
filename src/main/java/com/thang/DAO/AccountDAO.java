package com.thang.DAO;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thang.entity.Account;

public interface AccountDAO extends JpaRepository<Account, String> {

	@Query(value = "SELECT * FROM Accounts WHERE Username =?1 and Password = ?2", nativeQuery =true )
//	Account finallbyuser(String user);
	Account findAccountsByUsername(String username, String password); 
	
	@Query(value = "SELECT * FROM Accounts WHERE Username =?1 and Email = ?2", nativeQuery =true )
    Account finAccountbyUsernameEmail (String username,String email);
	@Query(value = "SELECT * FROM Accounts WHERE Username =?1 ", nativeQuery =true )
	Account finallbyusername(String username);
	
}
