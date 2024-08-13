package com.sunBank.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sunBank.enums.AccountStatus;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type",length = 4)
public class BankAccount {
	@Id
	private String id;
	
	private double balance;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Enumerated(EnumType.STRING) 
	// Here we assign default value Activated 
	private AccountStatus status = AccountStatus.ACTIVATED;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;
	
	@OneToMany(mappedBy = "bankAccount",fetch = FetchType.LAZY)
	private List<AccountOperation> accountOperationList;
}
