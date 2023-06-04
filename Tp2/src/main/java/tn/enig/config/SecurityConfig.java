package tn.enig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder crypt=cryptageMp();
		auth.inMemoryAuthentication().withUser("ali").password(crypt.encode("enig")).roles("AGENT");
		auth.inMemoryAuthentication().withUser("feriel").password(crypt.encode("enig")).roles("USER");
		
		auth.inMemoryAuthentication().withUser("emna").password(crypt.encode("enig")).roles("AGENT","ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		
		http.authorizeRequests().antMatchers("/ADD**/**","/DEL**/**").hasRole("ADMIN");
		
		http.authorizeRequests().anyRequest().authenticated();
		
	}
	
	 
	
	@Bean
	public PasswordEncoder cryptageMp() {
		return new BCryptPasswordEncoder();}
	
}
