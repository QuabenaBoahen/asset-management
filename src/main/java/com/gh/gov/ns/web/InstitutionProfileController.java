package com.gh.gov.ns.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String saveinstitutionProfile(Model model, Institution institution) {
		institutionRepository.saveAndFlush(institution);
		return "redirect:/institutions_entries";
	}

<<<<<<< HEAD

=======
>>>>>>> refs/remotes/origin/themeswitch
	@GetMapping("/suppliers_profile")
	public String suppliers_profile(Model model) {
		model.addAttribute("institution", new Institution());
		List<Institution> institutions = institutionRepository.findAll();
		model.addAttribute("institutions", institutions);
		return "suppliers_profile";
	}

	@GetMapping("/suppliers_profile_edit")
	public String suppliersProfileEdit(Model model) {
		model.addAttribute("institution", new Institution());
		List<Institution> institutions = institutionRepository.findAll();
		model.addAttribute("institutions", institutions);
		return "suppliers_profile_edit";
	}

}
