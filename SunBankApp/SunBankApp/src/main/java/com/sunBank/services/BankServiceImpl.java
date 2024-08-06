package com.sunBank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunBank.entities.BankAccount;
import com.sunBank.entities.Customer;
import com.sunBank.repositories.BankAccountRepository;


@Service
@Transactional
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;

	@Override
	public BankAccount findById(String Id) {
		

		BankAccount newBankAccount = bankAccountRepository.findById(Id).get();
		
		return newBankAccount;
	}

}
