package com.sunBank.dtos;

import java.util.List;

import lombok.Data;

@Data
public class AccountHistoryDTO {
	 public  String accountId;
	    public long customerId;
	    private double balance ;
	    private int currentPage;
	    private int totalPages;
	    private int pageSize;
	    List<AccountOperationDTO> accountOperationDTOList;
}
