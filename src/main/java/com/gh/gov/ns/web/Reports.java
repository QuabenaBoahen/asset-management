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
public class Reports {
	@Autowired
	private InstitutionRepository institutionRepository;

	@GetMapping("/institutions_report")
	public String institutionsReport(Model model) {

		return "institutions_report";
	}

	@GetMapping("/suppliers_report")
	public String suppliersReport(Model model) {

		return "suppliers_report";
	}

	@GetMapping("/reconciliation_report")
	public String reconciliationReport(Model model) {

		return "reconciliation_report";
	}
	
	@GetMapping("/supplied_vehicles_report")
	public String suppliedVehiclesReport(Model model) {

		return "supplied_vehicles_report";
	}
	
	
}
