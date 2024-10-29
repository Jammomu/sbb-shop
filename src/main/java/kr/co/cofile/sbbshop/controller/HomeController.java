package kr.co.cofile.sbbshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/api/search")
	public String search() {
		return "search";
	}
}
