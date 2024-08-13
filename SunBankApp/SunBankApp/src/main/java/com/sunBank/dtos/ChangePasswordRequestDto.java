package com.sunBank.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChangePasswordRequestDto {
	private String name;
	private String password;
	private String email;
}
