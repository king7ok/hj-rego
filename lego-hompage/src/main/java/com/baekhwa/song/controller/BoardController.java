package com.baekhwa.song.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/boards")
	public String list() {
		return "board/list";
	}
}
