package org.m2i.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
//est une class de configuration donc il faut le annoter @configuration
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//@Autowired
//	private DataSource dataSource;
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	/*auth.inMemoryAuthentication().withUser("admin").password("1234").roles("USER","ADMIN");
//	//auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
//	User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build(); 
//	
//*/
//		auth.jdbcAuthentication().dataSource(dataSource).
//		usersByUsernameQuery("select login as principal from,pass as credentials,active from users where login=?")
//		.authoritiesByUsernameQuery("select login as principal, role as role from users_roles where login=?")
//		.passwordEncoder(new Md4PasswordEncoder())
//		.rolePrefix("ROLE_");
//		;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.formLogin();
//		http.authorizeRequests().antMatchers("/index").hasRole("USER");
//	    http.authorizeRequests().antMatchers("/form","/save","edit","/delete").hasRole("ADMIN");
//	}
}
