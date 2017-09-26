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
public class Memo {
	@Autowired
	private InstitutionRepository institutionRepository;

	
	@GetMapping("/inbox_memo")
	public String inboxmemo(Model model) {

		return "inbox_memo";
	}
	@GetMapping("/compose_memo")
	public String composememo(Model model) {

		return "compose_memo";
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
