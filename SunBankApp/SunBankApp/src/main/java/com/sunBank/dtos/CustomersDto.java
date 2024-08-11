package com.sunBank.dtos;

import java.util.List;

import lombok.Data;

@Data
public class CustomersDto {

	List<CustomerDto> customerDTO;
	int totalpage;
	
}
