package com.accountApp.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.accountApp.model.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
	
	public Account findOneBy(String id);
	
	
}
