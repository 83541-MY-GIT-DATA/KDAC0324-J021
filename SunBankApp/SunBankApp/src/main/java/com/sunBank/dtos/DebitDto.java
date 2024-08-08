package com.sunBank.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DebitDto {
	private String accountId ;
    private double amount ;
    private String description ;
    private String upiId;
}
