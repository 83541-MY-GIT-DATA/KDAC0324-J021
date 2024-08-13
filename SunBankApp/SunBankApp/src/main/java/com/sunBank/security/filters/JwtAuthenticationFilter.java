package com.sunBank.security.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sunBank.security.utilities.JwtUtils;

import io.jsonwebtoken.Claims;

@Component	// can injected in other beans 
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private JwtUtils utils;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	
		// check auth header from incoming request 
		String authHeader = request.getHeader("Authorization");
		
		if(authHeader != null && authHeader.startsWith("Bearer "))
		{
			// req header contains jwt 
			String jwt = authHeader.substring(7);
			
			// validate jwt 
			Claims payLoads = utils.validateJwtToken(jwt);
			
			// get username from the class
			String username = utils.getUserNameFromToken(payLoads);
			
			// get granted authorities as a custom claim
			List<GrantedAuthority> authorities = utils.getAuthoritiesFromClaims(payLoads);
			
			// add username and granted authorities authentication object 
			
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username,null ,authorities);
			
			SecurityContextHolder.getContext().setAuthentication(token);
			
			System.out.println("Saved auth token in sec");	
		}
		
		filterChain.doFilter(request, response);
	}
	
}