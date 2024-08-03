package com.sunBank.entities;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DiscriminatorValue("SA")
public class SavingAccount extends BankAccount {
	private double interestRate;
}
