package com.sunBank.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CustomersDTO {

	List<CustomerDto> customerDTO;
	int totalpage;
	
}
