package br.com.po.imersao;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	 @Override
	  public void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	      .withUser("ed").password("ed").roles("USER").and()
	      .withUser("veloso").password("veloso").roles("USER", "ADMIN");
	  }
	
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	      .httpBasic().and()
	      .authorizeRequests()
	        .antMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
	        .antMatchers(HttpMethod.PUT, "/users/**").hasRole("ADMIN")
	        .and()
	      .csrf().disable();
	  }
	 
	
}
