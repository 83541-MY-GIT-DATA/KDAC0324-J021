package com.sunBank.dtos;

import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDetails {
	
	private String recipient;
	private String messageBody;
	private String subject;
	private String attachment;
	
}
