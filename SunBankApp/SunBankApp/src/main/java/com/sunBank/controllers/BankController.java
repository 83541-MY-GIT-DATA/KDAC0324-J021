package com.sunBank.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunBank.entities.BankAccount;
import com.sunBank.entities.Customer;
import com.sunBank.services.BankService;

@RestController
@RequestMapping("/banks")
public class BankController {

	private BankService bankService;
	
	
//	@GetMapping("/getDetails")
//	public ResponseEntity<Customer> getCustomerByEmail(@RequestHeader  String email)
//	{
//		return ResponseEntity.ok(customerService.searchByEmail(email));
//	}

@GetMapping("/getBank/id")
public ResponseEntity<BankAccount> getBankById(@RequestParam Long Id)
{
	return ResponseEntity.ok(bankService.findById(Id));
}

}
