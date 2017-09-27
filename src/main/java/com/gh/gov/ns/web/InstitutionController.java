package com.gh.gov.ns.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.model.Role;
import com.gh.gov.ns.model.User;
import com.gh.gov.ns.repository.InstitutionRepository;
import com.gh.gov.ns.repository.RoleRepository;
import com.gh.gov.ns.repository.UserRepository;
import com.gh.gov.ns.service.RoleService;

@Controller
public class InstitutionController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/institutions")
	public String institution(Model model){
		model.addAttribute("institution", new Institution());
		List<User> users=new ArrayList<>();
		List<User> supplierUsers=userRepository.findAll();
		for(User user : supplierUsers){
			if(!user.getRoleId().contentEquals("5")){
				Role role=roleRepository.findOne(user.getRoleId());
				if(role.getRoleName().contentEquals("INSTITUTION")){
					users.add(user);
				}
			}			
		}
		model.addAttribute("users", users);
		return "institutions";
	}
	
	@GetMapping("/add_institution")
	public String addInstitutions(Model model){
		model.addAttribute("user", new User());
		List<Role> roles = roleRepository.findAll();
		String institutionRoleId="";
		for(Role role : roles){
			if(role.getRoleName().equalsIgnoreCase("INSTITUTION")){
				institutionRoleId=role.getRoleId();
			}
		}
		model.addAttribute("institutionRoleId", institutionRoleId);
		return "add_institution";
	}
	
	@PostMapping("/add_institution")
	public String saveInstitutions(Model model, User user, @RequestParam("role_name") String role_name){
		Role role = roleRepository.findOne(role_name);
		if(role!=null){
			user.setRoleId(role.getRoleId());
			userRepository.saveAndFlush(user);
		}
		return "redirect:/add_institution";
	}
	
	@GetMapping("/suppliers")
	public String suppliers(Model model){
		model.addAttribute("institution", new Institution());
		List<User> users=new ArrayList<>();
		List<User> supplierUsers=userRepository.findAll();
		for(User user : supplierUsers){
			if(!user.getRoleId().contentEquals("5")){
				Role role=roleRepository.findOne(user.getRoleId());
				if(role.getRoleName().contentEquals("SUPPLIER")){
					users.add(user);
				}
			}			
		}
		model.addAttribute("supplierUsers", users);
		return "suppliers";
	}
	
	@GetMapping("/add_suppliers")
	public String addSuppliers(Model model){
		model.addAttribute("user", new User());
		List<Role> roles = roleRepository.findAll();
		String supplierRoleId="";
		for(Role role : roles){
			if(role.getRoleName().equalsIgnoreCase("SUPPLIER")){
				supplierRoleId=role.getRoleId();
			}
		}
		model.addAttribute("supplierRoleId", supplierRoleId);
		return "add_suppliers";
	}
	
	@PostMapping("/add_suppliers")
	public String saveSuppliers(Model model, User user, @RequestParam("role_name") String role_name){
		Role role = roleRepository.findOne(role_name);
		if(role!=null){
			user.setRoleId(role.getRoleId());
			userRepository.saveAndFlush(user);
		}
		return "redirect:/add_suppliers";
	}

}
