package com.gh.gov.ns.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping("/login")
	public String index(){
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(){
		return "dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(Principal principal) {
		return "login";
	}

}
