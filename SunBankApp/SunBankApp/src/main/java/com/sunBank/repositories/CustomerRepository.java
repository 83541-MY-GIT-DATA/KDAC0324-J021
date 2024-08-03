package com.sunBank.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sunBank.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	Customer findByEmail(String email);
}
