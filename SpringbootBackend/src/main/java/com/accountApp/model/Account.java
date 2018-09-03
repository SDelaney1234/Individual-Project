package com.accountApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private String id;
	private String firstname;
	private String surname;
	private String accountnumber;
	
	public Account() {}
	
	public Account(String firstname,String surname,String accountnumber) {
		this.firstname= firstname;
		this.surname= surname;
		this.accountnumber= accountnumber;
	}

	@Override
	public String toString() {
		return "Firstname: " + firstname + "\nSurname: " + surname + 
				"\nAccount number: " + accountnumber;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
