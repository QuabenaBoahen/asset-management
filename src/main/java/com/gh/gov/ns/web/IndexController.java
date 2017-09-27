package com.gh.gov.ns.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gh.gov.ns.model.Role;
import com.gh.gov.ns.model.User;
import com.gh.gov.ns.repository.RoleRepository;
import com.gh.gov.ns.repository.UserRepository;

@Controller
public class IndexController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/login")
	public String index(){
		return "login";
	}
	
	@GetMapping({"/", "/dashboard"})
	public String dashboard(Principal principal){
		String redirectPage="";
		User user = userRepository.findUserByUsername(principal.getName());
		if(user!=null){
			Role role = roleRepository.findOne(user.getRoleId());
			if(role.getRoleName().equalsIgnoreCase("INSTITUTION")){
				redirectPage="redirect:/institution_profile";
			}else if(role.getRoleName().equalsIgnoreCase("SUPPLIER")){
				redirectPage="redirect:/suppliers_profile";
			}else if(role.getRoleName().equalsIgnoreCase("NS")){
				redirectPage="dashboard";
			}
		}
		return redirectPage;
	}
	
	@GetMapping("/logout")
	public String logout(Principal principal) {
		return "login";
	}

}
