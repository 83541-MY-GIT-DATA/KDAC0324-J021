package com.sunBank.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunBank.dtos.AccountHistoryDto;
import com.sunBank.dtos.AccountOperationDto;
import com.sunBank.dtos.BankAccountDto;
import com.sunBank.dtos.BankAccountsDto;
import com.sunBank.dtos.CurrentBankAccountDto;
import com.sunBank.dtos.CustomerDto;
import com.sunBank.dtos.CustomersDto;
import com.sunBank.dtos.SavingBankAccountDto;
import com.sunBank.entities.Customer;
import com.sunBank.exceptions.BalanceNotSufficientException;
import com.sunBank.exceptions.BankAccountNotFound;
import com.sunBank.exceptions.CustomerNotFoundException;

@Service
public interface BankAccountService {
	CustomerDto saveCustomer(CustomerDto customerDto) throws CustomerNotFoundException;
	
	SavingBankAccountDto saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
	
	CurrentBankAccountDto saveCurrentBankAccount(double initialBalance , double overdraft,Long customerId) throws CustomerNotFoundException;
	
	List<CustomerDto> listCustomers(int page);
	
	List<Customer> listCustomer();
	
	List<BankAccountDto> bankAccountListOfCustomer(Long customerId);
	
	BankAccountDto getBankAccount(String accountId) throws BankAccountNotFound;
	
	BankAccountsDto getBankAccountList(int page);
	
	CustomerDto getCustomer(Long customerId) throws CustomerNotFoundException;
	
	CustomerDto updateCustomer(CustomerDto customerDto);
	
	BankAccountDto updateBankAccount(BankAccountDto bankAccountDto);
	
	void deleteCustomer(Long customerId);
	
	CustomerDto getCustomerByName(String name);
	
//	CustomersDto getCustomerByName(String keyword,int page) throws CustomerNotFoundException;
	
	List<AccountOperationDto> accountOperationHistory(String accountId);
	
	AccountHistoryDto getAccountHistory (String accountId,int page,int size) throws BankAccountNotFound;
	
	void debit(String accountId, double amount, String description, String upiId) throws BalanceNotSufficientException, BankAccountNotFound;
	
	void credit(String accountId, double amount, String description) throws BankAccountNotFound;
	
	void transfer(String accountIdSource, String accountIdDestination, double amount, String description) throws BankAccountNotFound, BalanceNotSufficientException;
}
