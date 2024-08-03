package com.sunBank.entities;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sunBank.enums.OperationType;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountOperation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Date operationDate;
	private double amount;
	private OperationType operationType;
	@Column(name = "description",length = 255)
	private String description;
	
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private BankAccount bankAccount;
}
