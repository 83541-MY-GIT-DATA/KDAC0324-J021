package com.sunBank.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class FdDTO {

	private String accountId ;
    private double amount ;
    private String description ;
    private LocalDate createdDate=LocalDate.now();
    private double interestRate=7.00;
}
