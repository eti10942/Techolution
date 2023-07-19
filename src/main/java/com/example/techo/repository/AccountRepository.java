package com.example.techo.repository;

import org.springframework.stereotype.Repository;

import com.example.techo.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

	Account findByAccountNumber(String accountNumber);

	Account findByAccountName(String accountName);

}
