package com.baekhwa.song.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.baekhwa.song.domain.dto.member.MemberInsertDTO;
import com.baekhwa.song.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class MemberController {
	
	
	private final MemberService service;
	
	@PostMapping("/common/signup")
	public String signup(MemberInsertDTO dto, HttpServletRequest request) {
		return service.save(dto, request);
	}
	

}
