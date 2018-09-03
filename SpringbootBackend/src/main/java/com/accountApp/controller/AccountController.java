package com.accountApp.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import com.accountApp.model.Account;
import com.accountApp.repository.AccountRepository;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepo;
	
	@RequestMapping(value= "/all", method= RequestMethod.GET)
	public Collection<Account> getAllAccounts(){
		return accountRepo.findAll();
	}
	
	@RequestMapping(value= "/create", method= RequestMethod.POST)	//<-- ENTER A PATH?
	public String createAccount(@RequestBody Account account) {
		accountRepo.save(account);
		return account.getId();
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Account getAccount(@PathVariable String id) {
		return accountRepo.findOne(id);
	}
	
	@RequestMapping(value= "/update/{id}", method=RequestMethod.PUT)
	public Account update(@RequestBody Account account){
		return accountRepo.save(account);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable String id){
		accountRepo.delete(id);
	}

}
