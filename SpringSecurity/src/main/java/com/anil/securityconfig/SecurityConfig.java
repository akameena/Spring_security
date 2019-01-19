package com.anil.securityconfig;

import org.eclipse.jdt.internal.compiler.ast.AND_AND_Expression;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		//.anyRequest().authenticated()
		.antMatchers("/").hasRole("EMP")
		.antMatchers("/hr/**").hasRole("HR")
		.antMatchers("/accountant").hasRole("ACCOUNTANT")
		.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/aaa")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/restrication");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("anil").password("pass123").roles("EMP"))
		.withUser(users.username("anil2").password("pass123").roles("HR","EMP"))
		.withUser(users.username("anil3").password("pass123").roles("ACCOUNTANT","EMP"));
	}
	
	
	
}
