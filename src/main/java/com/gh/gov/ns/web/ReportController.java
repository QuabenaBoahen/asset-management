package com.gh.gov.ns.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.gh.gov.ns.model.InstitutionEntries;
import com.gh.gov.ns.repository.InstitutionEntryRepository;
import com.gh.gov.ns.repository.SuppliersEntryRepository;

@Controller
public class ReportController {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private InstitutionEntryRepository institutionEntryRepository;
	
	@Autowired
	private SuppliersEntryRepository suppliersEntryRepository;

	@GetMapping("/institutions_report")
	public String institutionsReport(Model model) {
		model.addAttribute("institutionEntries", institutionEntryRepository.findAll());
		return "institutions_report";
	}

	@GetMapping("/suppliers_report")
	public String suppliersReport(Model model) {
   model.addAttribute("suppliersEntriesReport", suppliersEntryRepository.findAll());
		return "suppliers_report";
	}

	@GetMapping("/reconciliation_report")
	public String reconciliationReport(Model model) {
List<InstitutionEntries> reconciliationReport = institutionEntryRepository.reconcilationReport("");
   model.addAttribute("reconciliationReport", reconciliationReport);
		return "reconciliation_report";
	} 
	
	@GetMapping("/updateSuppliersEntries")
	public String updateInstitutionReconciliationReport(Model model, @RequestParam(value="institution", required=false) String institution) {
List<InstitutionEntries>  reconciliationReport= institutionEntryRepository.reconcilationReport(institution);
   model.addAttribute("reconciliationReport", reconciliationReport);
		return "reconciliation_report";
	}
	
	@GetMapping("/supplied_vehicles_report")
	public String suppliedVehiclesReport(Model model) {
		return "supplied_vehicles_report";
	}
	
	@GetMapping("/test_report")
    public ModelAndView report() {
        JasperReportsPdfView view = new JasperReportsPdfView();
        view.setUrl("classpath:Institutions_report.jrxml");
        view.setApplicationContext(applicationContext);
        Map<String, Object> params = new HashMap<>();
        params.put("datasource", institutionEntryRepository.findAll());
        return new ModelAndView(view, params);
    }
	
	
}
