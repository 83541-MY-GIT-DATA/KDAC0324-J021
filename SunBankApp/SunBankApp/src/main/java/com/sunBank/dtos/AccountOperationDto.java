package com.sunBank.dtos;

import java.time.LocalDateTime;
import com.sunBank.enums.OperationType;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountOperationDto {

	private Long id ;
    private LocalDateTime operationDate;
    private double amount;
    private OperationType type;
    private String description;
    private String accountId;
    
}
