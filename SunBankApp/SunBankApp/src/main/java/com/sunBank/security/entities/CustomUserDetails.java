package com.sunBank.security.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class CustomUserDetails implements UserDetails {
	
	private AppUser appUser;
	
	public CustomUserDetails(AppUser appUser)
	{
		super();
		this.appUser = appUser;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// return list pf granted authorities 
		return appUser.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))   // converted each role to granted authority 
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return appUser.getPassword();
	}

	@Override
	public String getUsername() {
		return appUser.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
