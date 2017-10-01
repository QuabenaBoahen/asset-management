package com.gh.gov.ns.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.repository.InstitutionRepository;

@Controller
public class InstitutionProfileController {
	@Autowired
	private InstitutionRepository institutionRepository;

	@GetMapping("/institution_profile")
	public String showProfile(Model model) {
		model.addAttribute("institution", new Institution());
		return "institution_profile";
	}

	@PostMapping("/institution_profile")
	public String saveinstitutionProfile(Model model, Institution institution,
			@RequestParam("institutionId") String institutionId, @RequestParam("name") String name) {
		institution.setInstitutionId(institutionId);
		institution.setName(name);
		institutionRepository.saveAndFlush(institution);
		return "redirect:/institutions_entries";
	}

	@GetMapping("/suppliers_profile")
	public String showProfileSupplier(Model model) {
		model.addAttribute("institution", new Institution());
		return "suppliers_profile";
	}

	@PostMapping("/suppliers_profile")
	public String saveSuppliersProfile(Model model, Institution institution,
			@RequestParam("supplierId") String supplierId, @RequestParam("name") String name) {
		institution.setInstitutionId(supplierId);
		institution.setName(name);
		institutionRepository.saveAndFlush(institution);
		return "redirect:/suppliers_entries";
	}

	

	

}
