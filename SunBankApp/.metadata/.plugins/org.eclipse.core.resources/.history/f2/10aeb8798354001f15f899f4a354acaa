package com.sunBank.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunBank.entities.Customer;
import com.sunBank.repositories.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer searchByEmail(String email) {
		Customer newCustomer = customerRepository.findByEmail(email);
		return newCustomer;
	}
}
