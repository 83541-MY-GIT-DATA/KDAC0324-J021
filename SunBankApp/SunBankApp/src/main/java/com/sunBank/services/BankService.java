package com.sunBank.services;

import com.sunBank.entities.BankAccount;

public interface BankService {
	BankAccount findById(String Id);
}
