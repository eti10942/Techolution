package com.example.techo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.techo.model.Account;
import com.example.techo.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private  AccountRepository accountRepository;
	

	   public Page<Account> getAllAccounts(PageRequest pageRequest) {
	        return accountRepository.findAll(pageRequest);
	    }


	public Account getAccountByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}


	public Account getAccountByAccountName(String accountName) {
		// TODO Auto-generated method stub
		return accountRepository.findByAccountName(accountName);
	}


	public Account createAccount(Account account) {

		return accountRepository.save(account);
	}


	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}


}
