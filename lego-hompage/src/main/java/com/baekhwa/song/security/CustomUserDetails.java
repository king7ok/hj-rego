package com.baekhwa.song.security;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.baekhwa.song.domain.entity.Member;

import lombok.Getter;

@Getter
public class CustomUserDetails extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String name;
	

	//Super 클래스에 super()존재하지않고 다른생성자(오버로딩생성자)만 존재경우 생성자 명시
	public CustomUserDetails(Member e) {
		super(e.getEmail(), e.getPass(), e.getRoleSet().stream()
													.map(role->new SimpleGrantedAuthority(role.roleName))// Set<MemberRole> -> Collection<? extends GrantedAuthority> authorities
													.collect(Collectors.toSet()));
		email=e.getEmail();
		name=e.getName();
	}

}
