package com.sunBank.dtos;

import java.time.LocalDateTime;

import com.sunBank.enums.OperationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountOperationDTO {
	private Long id ;
    private LocalDateTime operationDate;
    private double amount;
    private OperationType type;
    private String description;
    private String accountId;

}
