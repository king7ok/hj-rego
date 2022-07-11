package com.baekhwa.song.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
	
	
	//private final CustomAuthenticationFailureHandler failureHandler;
	//private final CustomAuthenticationSuccessHandler successHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CustomAuthenticationFailureHandler failureHandler() {
		return new CustomAuthenticationFailureHandler();
	}
		
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests(authorize -> 
			authorize
				.antMatchers("/","/common/**","/login").permitAll()
				.anyRequest().authenticated()
			);
		
		///로그인페이지 설정
		http.formLogin(formLogin ->
			formLogin
				.loginPage("/login")//get 로그인페이지이동 url
				.usernameParameter("email")
				.passwordParameter("pass")
				.failureUrl("/login?errMsg")
				.loginProcessingUrl("/login")//form action post Security가 처리해주는 url -> UserdetailsService
				.defaultSuccessUrl("/", true)
				//.successHandler(successHandler)
				//.failureHandler(failureHandler())//로그인실패시 처리
				.permitAll()
		);
		
		http.logout(logout->logout.logoutSuccessUrl("/"));//default is "/login?logout".
		
		http.csrf();
			
		return http.build();
	}
	
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers(
        		"/css/**"
        		,"/js/**"
        		,"/images/**"
        		,"/favicon.ico*"
        		);
    }
	
	
	
}
