package com.sunBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunBank.entities.Customer;
import com.sunBank.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getDetails")
	public ResponseEntity<Customer> getCustomerByEmail(@RequestHeader  String email)
	{
		return ResponseEntity.ok(customerService.searchByEmail(email));
	}
}
