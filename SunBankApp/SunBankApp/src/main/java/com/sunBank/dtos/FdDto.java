package com.sunBank.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
public class FdDto {
	private String accountId;
	private double amount;
	private String description;
	private LocalDate createdDate = LocalDate.now();
	private double interestRate = 7.00;  // fd interest rate 
}