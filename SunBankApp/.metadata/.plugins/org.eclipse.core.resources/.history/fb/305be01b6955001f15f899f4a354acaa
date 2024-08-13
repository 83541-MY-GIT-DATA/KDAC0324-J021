package com.sunBank.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sunBank.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	Customer findByEmail(String email);
	
	Customer getCustomerByName(String name);
	
	@Query("Select c from Customer where c.name like :mn")
	Page<Customer> searchByName(@Param("mn")String keyword, Pageable pageable);
	
	Page<Customer> findAll(Pageable pageable);
	
}
