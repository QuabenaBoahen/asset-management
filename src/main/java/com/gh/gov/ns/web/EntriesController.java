package com.gh.gov.ns.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gh.gov.ns.model.InstitutionEntries;
import com.gh.gov.ns.model.SuppliersEntries;
import com.gh.gov.ns.repository.InstitutionEntryRepository;
import com.gh.gov.ns.repository.SuppliersEntryRepository;

@Controller
public class EntriesController {
	@Autowired
	private InstitutionEntryRepository institutionEntryRepository;
	
	@Autowired
	private SuppliersEntryRepository suppliersEntryRepository;

	@GetMapping("/institutions_entries")
	public String institutionsEntries(Model model) {
      List<InstitutionEntries> institutionEntries = institutionEntryRepository.findAll();
      model.addAttribute("institutionEntries", institutionEntries);
		return "institutions_entries";
	}

	@GetMapping("/institutions_entries_new")
	public String institutionsEntriesNew(Model model) {
		model.addAttribute("institutionEntry", new InstitutionEntries());
		return "institutions_entries_new";
	}
	
	@PostMapping("/institutions_entries_new")
	public String saveinstitutionsEntriesNew(Model model, InstitutionEntries entries) {
		institutionEntryRepository.saveAndFlush(entries);
		return "redirect:/institutions_entries_new";
	}
	
	@GetMapping("/suppliers_entries_new")
	public String suppliersEntriesNew(Model model) {
        model.addAttribute("suppliersEntries", new SuppliersEntries());
		return "suppliers_entries_new";
	}
	
	@PostMapping("/suppliers_entries_new")
	public String saveSuppliersEntriesNew(Model model, SuppliersEntries suppliers) {
		suppliersEntryRepository.saveAndFlush(suppliers);
		return "redirect:/suppliers_entries_new";
	}
	
	@GetMapping("/suppliers_entries")
	public String suppliersEntries(Model model) {
		List<SuppliersEntries> suppliersEntries = suppliersEntryRepository.findAll();
		model.addAttribute("suppliersEntries", suppliersEntries);
		return "suppliers_entries";
	}

	
}
