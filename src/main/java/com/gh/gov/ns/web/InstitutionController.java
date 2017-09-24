package com.gh.gov.ns.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.repository.InstitutionRepository;

@Controller
public class InstitutionController {
	@Autowired
	private InstitutionRepository institutionRepository;
	
	@GetMapping("/institutions")
	public String institution(Model model){
		model.addAttribute("institution", new Institution());
		List<Institution> institutions=institutionRepository.findAll();	
		model.addAttribute("institutions", institutions);
		return "institutions";
	}
	
	@PostMapping("/institutions")
	public String allInstitutions(Institution institution){
		institutionRepository.saveAndFlush(institution);
		return "redirect:/institutions";
	}

}
