package com.baekhwa.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
	@GetMapping("/login")
	public String login() {
		return "sign/signin";
	}
	@GetMapping("/common/signup")
	public String signup() {
		return "sign/signup";
	}
}
