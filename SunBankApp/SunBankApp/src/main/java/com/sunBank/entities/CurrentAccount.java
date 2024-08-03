package com.sunBank.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends BankAccount {
	
	private double overDraft;
}
