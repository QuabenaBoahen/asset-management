package com.gh.gov.ns.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.model.Letters;
import com.gh.gov.ns.model.User;
import com.gh.gov.ns.repository.InstitutionRepository;
import com.gh.gov.ns.repository.LettersRepository;
import com.gh.gov.ns.repository.UserRepository;

@Controller
public class LettersController {
	@Autowired
	private LettersRepository lettersRepository;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InstitutionRepository institutionRepository;

	
	@GetMapping("/inbox_letters")
	public String inboxLetters(Model model) {

		return "inbox_letters";
	}

	@GetMapping("/compose_letter")
	public String composeLetter(Model model) {
		model.addAttribute("letters", new Letters());
		List<Letters> lettersall = lettersRepository.findAll();
		List<User> users = userRepository.findAll();
		model.addAttribute("lettersall", lettersall);
		model.addAttribute("users", users);
		return "compose_letter";
	}

	/*@PostMapping("/compose_letter")
	public String composeNewLetter(Letters letters) {
		lettersRepository.saveAndFlush(letters);
		return "redirect:/compose_letter";
	}
	*/
	@PostMapping("/compose_letter")
	public String previewLetter(Letters letters, HttpSession session) {
		session.setAttribute("recipient", letters);
		lettersRepository.saveAndFlush(letters);
		return "redirect:/letter_preview";
	}

	@GetMapping("/draft_letters")
	public String draftLetters(Model model) {

		return "draft_letters";
	}

	@GetMapping("/sent_letters")
	public String sentLetters(Model model) {

		return "sent_letters";
	}

	@GetMapping("/selected_letter")
	public String selectedLetter(Model model) {

		return "selected_letter";
	}
/*	@GetMapping("/letter_preview")
	public String letterPreview(Model model, @RequestParam("id") String name) {
	 Institution institution = institutionRepository.findInstitutionByName(name);
		model.addAttribute("institution", institution);
//	model.addAttribute("content", arg1);
		System.out.println("institution is ...." +institution+".....");
		System.out.println("name is ...." +name+".....");
		return "letter_preview";
	}*/

	@GetMapping("/letter_preview")
	public String letterPreview(Model model) {
		return "letter_preview";
	}
}
