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
import com.gh.gov.ns.repository.LettersRepository;

@Controller
public class Letters {
	@Autowired
	private LettersRepository lettersRepository;

	
	@GetMapping("/inbox_letters")
	public String inboxLetters(Model model) {

		return "inbox_letters";
	}
	@GetMapping("/compose_letter")
	public String composeLetter(Model model) {

		return "compose_letter";
	}
	
	@PostMapping("/compose_letter")
	public String composeNewLetter(Letters letters) {
		lettersRepository.saveAndFlush(letters);
		return "redirect:/compose_letter";
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
	
	@GetMapping("/letter_preview")
	public String letterPreview(Model model) {

		return "letter_preview";
	}
}
