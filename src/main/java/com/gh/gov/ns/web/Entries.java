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
public class Entries {
	@Autowired
	private InstitutionRepository institutionRepository;

	@GetMapping("/suppliers_entries")
	public String suppliersEntries(Model model) {

		return "suppliers_entries";
	}

	@GetMapping("/institutions_entries")
	public String institutionsEntries(Model model) {

		return "institutions_entries";
	}

	@GetMapping("/institutions_entries_new")
	public String institutionsEntriesNew(Model model) {

		return "institutions_entries_new";
	}
	
	@GetMapping("/suppliers_entries_new")
	public String suppliersEntriesNew(Model model) {

		return "suppliers_entries_new";
	}
	
	@GetMapping("/attach_docs_suppl")
	public String attachDocsSuppl (Model model) {

		return "attach_docs_suppl";
	}

	@GetMapping("/attach_docs_inst")
	public String attachDocsInst(Model model) {

		return "attach_docs_inst";
	}

	
}
