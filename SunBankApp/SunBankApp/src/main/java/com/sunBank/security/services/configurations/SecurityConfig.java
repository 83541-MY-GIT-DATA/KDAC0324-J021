package com.sunBank.security.services.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sunBank.security.filters.JwtAuthenticationFilter;
import com.sunBank.security.services.UserDetailsServiceImpl;

@Configuration  // to tell sc this is config class 
public class SecurityConfig {
	@Autowired
	@Qualifier("customPasswordEncoder")
	@Lazy
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private CustomAuthenicationEntryPoint customAuthenicationEntryPoint;
	
	@Autowired
	@Lazy
	private UserDetailsServiceImpl  userDetailsServiceImpl;
	
	public void setUserDetailsServiceImpl(UserDetailsServiceImpl userDetailsServiceImpl)
	{
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http)  throws Exception
	{
		http.cors().and().cors().disable()
		.exceptionHandling().authenticationEntryPoint(customAuthenicationEntryPoint)
		.and()
		.authorizeRequests()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.antMatchers("/refreshToken/**","/login/**","/customers/save","/verifyOtp","/changepassword","/statement","/v*/api-doc*/**","/swagger-ui/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	
	// configure authentication manager 
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
	
	@Bean(name = "customPasswordEncoder")
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomAuthenicationEntryPoint customAuthenicationEntryPoint()
	{
		return new CustomAuthenicationEntryPoint();
	}
}
