package com.kh.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	// 홈
	@GetMapping("home")
	public String showHomePage() {
		return "home";
	}
	
}
