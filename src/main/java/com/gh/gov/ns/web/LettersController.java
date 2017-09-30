package com.gh.gov.ns.web;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.gh.gov.ns.model.Letters;
import com.gh.gov.ns.model.User;
import com.gh.gov.ns.repository.LettersRepository;
import com.gh.gov.ns.repository.UserRepository;
import com.gh.gov.ns.utils.DateFormatter;

@Controller
@SessionAttributes({"savedLetter"})
public class LettersController {
	@Autowired
	private LettersRepository lettersRepository;
	@Autowired
	private UserRepository userRepository;
	
	private Letters savedLetter;
	
	@Autowired
	private DateFormatter dateFormatter;

	
	@GetMapping("/inbox_letters")
	public String inboxLetters(Model model) {
		return "inbox_letters";
	}

	@GetMapping("/compose_letter")
	public String composeLetter(Model model) {
		model.addAttribute("letter", new Letters());
		if(savedLetter!=null) {
			model.addAttribute("savedLetter", savedLetter);
		}else {
			model.addAttribute("savedLetter", "");
		}		
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		return "compose_letter";
	}

	@PostMapping("/compose_letter")
	public String previewLetter(Letters letter, Model model, @RequestParam("subject") String subject, 
			@RequestParam("content") String content, @RequestParam(value="letterId", required=false) String letterId) {
		letter.setDate(dateFormatter.currentDateFormmater(LocalDate.now()));
		letter.setLetterId(letterId);
		letter.setSubject(subject);
		letter.setContent(content);
		Letters savedLetters=lettersRepository.saveAndFlush(letter);
		savedLetter = savedLetters;
		return "redirect:/letter_preview";
	}

	@GetMapping("/draft_letters")
	public String draftLetters(Model model) {
    List<Letters> previouslySavedLetters = lettersRepository.findAll();
    model.addAttribute("drafts", previouslySavedLetters);
		return "draft_letters";
	}

	@GetMapping("/selected_letter")
	public String selectedLetter(Model model) {
		return "selected_letter";
	}

	@GetMapping("/letter_preview")
	public String letterPreview(Model model) {
		model.addAttribute("letters", savedLetter);
		return "letter_preview";
	}
	
	@GetMapping("/logout")
	public String logout(Principal principal) {
		return "redirect:/login";
	}
}
