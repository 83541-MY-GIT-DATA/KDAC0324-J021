package com.sunBank.security.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunBank.security.entities.AppRole;
import com.sunBank.security.entities.AppUser;
import com.sunBank.security.entities.RoleUserForm;
import com.sunBank.security.services.AccountService;

import lombok.Data;

@RestController
@CrossOrigin("*")
public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	
	public AccountRestController(AccountService accountService)
	{
		this.accountService = accountService;
	}
	
	// display users 
	@GetMapping(path = "/users")
	@PostAuthorize("hasAuthority('USER')")
	public List<AppUser> appUsers()
	{
		return accountService.listUsers();
	}
	
	// add new users 
	@PostMapping(path = "/users")
	@PostAuthorize("hasAuthority('ADMIN')")
	public AppUser saveUser(@RequestBody AppUser appUser)
	{
		return accountService.addNewUser(appUser);
	}
	
	// add new role
	@PostMapping(path = "/roles")
	@PostAuthorize("hasAuthority('ADMIN')")
	public AppRole saveRole(@RequestBody AppRole appRole)
	{
		return accountService.addNewRole(appRole);
	}
	
	// add role to user
	@PostMapping(path = "/addRoleToUser")
	public void addRoleToUser(@RequestBody RoleUserForm roleUserForm)
	{
		accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRolename());
		
	}
	
//	//refresh token 
//	@GetMapping(path = "/refreshToken")
//	public void refreshToken(HttpServletRequest request,HttpServletResponse response) throws Exception
//	{
//		String
//	}
}