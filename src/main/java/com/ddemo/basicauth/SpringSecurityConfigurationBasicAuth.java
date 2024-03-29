package com.ddemo.basicauth;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(new MyCORSFilter(), ChannelProcessingFilter.class);
		http
		.csrf().disable()	
		.authorizeRequests()
		.antMatchers("/").permitAll()
				.anyRequest().fullyAuthenticated()
				.and()
			//.formLogin().and()
			.httpBasic();
	}
	
}
