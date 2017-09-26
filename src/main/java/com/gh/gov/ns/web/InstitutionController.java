package com.gh.gov.ns.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	private InstitutionRepository institutionRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/institutions")
	public String institution(Model model){
		model.addAttribute("institution", new Institution());
		List<User> users=new ArrayList<User>();
		List<User> institutionsRegistered = userRepository.findAll();
		/*for(User user : institutionsRegistered){
			String institutionRegistered = user.getRole().getRoleId();
			Role role = roleRepository.findOne(institutionRegistered);
			if(role.getRoleName().contentEquals("INSTITUTION")){
				users.add(user);
			}
		}*/
		model.addAttribute("users", institutionsRegistered);
		return "institutions";
	}
	
	@GetMapping("/add_institution")
	public String addInstitutions(Model model){
		model.addAttribute("user", new User());	
		return "add_institution";
	}
	
	@PostMapping("/add_institution")
	public String saveInstitutions(Model model, User user, @RequestParam("role_name") String role_name){
		//Role role= roleService.findRoleByRoleName(role_name);
		Role role=new Role();
		role.setRoleId("1");
		role.setRoleName("INSTITUTION");
		//if(role!=null){
		user.setRole(role);	
		//}
		userRepository.saveAndFlush(user);
		
		return "redirect:/add_institution";
	}
	
	@GetMapping("/suppliers")
	public String suppliers(Model model){
		model.addAttribute("institution", new Institution());
		List<Institution> institutions=institutionRepository.findAll();	
		model.addAttribute("institutions", institutions);
		return "suppliers";
	}
	
	@GetMapping("/add_suppliers")
	public String addSuppliers(Model model){
		model.addAttribute("institution", new Institution());
		List<Institution> institutions=institutionRepository.findAll();	
		model.addAttribute("institutions", institutions);
		return "add_suppliers";
	}
	
	@PostMapping("/add_suppliers")
	public String saveSuppliers(Model model, User user, @RequestParam("role_name") String role_name){
		Role role= roleService.findRoleByRoleName(role_name);
		if(role!=null){
		//user.setRoleId(role.getRoleId());	
		}
		
		userRepository.saveAndFlush(user);
		return "redirect:/add_suppliers";
	}

}
