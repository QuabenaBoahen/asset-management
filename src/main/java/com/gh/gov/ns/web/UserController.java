package com.gh.gov.ns.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/users")
	public String users() {
		return "users";
	}

	@GetMapping("/useraccount")
	public String userAccount() {
		return "useraccount";
	}

	@GetMapping("/add_user")
	public String addUser() {
		return "add_user";
	}

}
