package com.example.techo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.techo.model.Account;
import com.example.techo.service.AccountService;

@RestController  
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	  private  AccountService accountService;

	
	  @GetMapping("getAll")
	    public Page<Account> getAllAccounts( @RequestParam(defaultValue = "0") int page,
	    		@RequestParam(defaultValue = "10") int size) {
	        PageRequest pageRequest = PageRequest.of(page, size);
	        return accountService.getAllAccounts(pageRequest);
	    }
	  
	  @GetMapping("findAccount")
	    public Account getAccountByNumberOrName(@RequestParam(required = false) String accountNumber,
	        @RequestParam(required = false) String accountName) {
		  Account account = null;
	        if (accountNumber != null) {
	             account= accountService.getAccountByAccountNumber(accountNumber);
	        } else if (accountName != null) {
	            account= accountService.getAccountByAccountName(accountName);
	        }
			return account;
	        
	    }
	  
	  @PostMapping("createAccount")
	    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	        Account createdAccount = accountService.createAccount(account);
	        return ResponseEntity.ok(createdAccount);
	    }
	  
	  @PutMapping("updateAccount/{accountNumber}")
	    public ResponseEntity<Account> updateAccount(@PathVariable String accountNumber, @RequestBody Account updatedAccount) {
	        Account account = accountService.getAccountByAccountNumber(accountNumber);
	        
	        if (account == null) {
	            return ResponseEntity.notFound().build();
	        }

	        
	        account.setAccountName(updatedAccount.getAccountName());
	        account.setAccountNumber(updatedAccount.getAccountNumber());
	        

	         updatedAccount = accountService.updateAccount(account);

	        return ResponseEntity.ok(updatedAccount);
	    }
	  

	}
	     



