package com.kh.teamprj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@GetMapping("/main")
	public String home(){
		return "main/main";
	}
	
	@GetMapping("/remember")
	public String remember(){
		return "game/remember";
	}
	
	@GetMapping("/random")
	public String random(){
		return "game/random";
	}
	
	@GetMapping("/click")
	public String click(){
		return "game/click";
	}
}
