package com.sunBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunBank.entities.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
		
}
