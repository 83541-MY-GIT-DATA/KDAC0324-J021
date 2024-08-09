package com.sunBank.dtos;

import java.util.List;

import lombok.Data;

@Data
public class BankAccountsDto {
	List<BankAccountDto> bankAccountDtos;
	int totalPage;
}
