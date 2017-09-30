package com.gh.gov.ns.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.model.Memo;
import com.gh.gov.ns.repository.InstitutionRepository;
import com.gh.gov.ns.repository.MemoRepository;

@Controller
public class MemoController {
	@Autowired
	private MemoRepository memoRepository ;
	
	@GetMapping("/inbox_memo")
	public String inboxmemo(Model model) {

		return "inbox_memo";
	}
	@GetMapping("/compose_memo")
	public String composememo(Model model) {
		model.addAttribute("memo", new Memo());
		return "compose_memo";
	}
	@PostMapping("/compose_memo")
	public String createMemo(Memo memo) {
	memoRepository.saveAndFlush(memo);
	return "redirect:/compose_memo";
	}

	@GetMapping("/draft_memo")
	public String draftmemo(Model model) {

		return "draft_memo";
	}
	@GetMapping("/sent_memo")
	public String sentmemo(Model model) {
		return "sent_memo";
	}
	
	@GetMapping("/selected_memo")
	public String selectedmemo(Model model) {
		return "selected_memo";
	}
	
	@GetMapping("/memo_preview")
	public String memoPreview(Model model) {

		return "memo_preview";
	}
}
