package com.sunBank.dtos;

import java.util.Date;

import com.sunBank.enums.AccountStatus;

import lombok.Data;

@Data
public class BankAccountDTO {
	 private String id;
	    private double balance;
	    private Date createdAt;
	    private AccountStatus status;
	    private CustomerDto customerDTO;
	    private double overDraft;
	    private String type ;
	    private double interestRate ;

}
