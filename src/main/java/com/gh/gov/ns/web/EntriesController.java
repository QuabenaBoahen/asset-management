package com.gh.gov.ns.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gh.gov.ns.model.Documents;
import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.model.InstitutionEntries;
import com.gh.gov.ns.model.SuppliersEntries;
import com.gh.gov.ns.repository.DocumentsRepository;
import com.gh.gov.ns.repository.InstitutionEntryRepository;
import com.gh.gov.ns.repository.InstitutionRepository;
import com.gh.gov.ns.repository.SuppliersEntryRepository;
import com.gh.gov.ns.utils.DateFormatter;

@Controller
public class EntriesController {

	@Autowired
	private DocumentsRepository DocumentsRepository;

	private static String UPLOADED_FOLDER = "C://Users/Quabena/Desktop/uploads/";

	@Autowired
	private InstitutionEntryRepository institutionEntryRepository;

	@Autowired
	private SuppliersEntryRepository suppliersEntryRepository;
	
	@Autowired
	private InstitutionRepository institutionRepository;
	
	@Autowired
	private DateFormatter dateFormatter;

	@GetMapping("/institutions_entries")
	public String institutionsEntries(Model model) {
		List<InstitutionEntries> institutionEntries = institutionEntryRepository.findAll();
		model.addAttribute("institutionEntries", institutionEntries);
		return "institutions_entries";
	}

	@GetMapping("/institutions_entries_new")
	public String institutionsEntriesNew(Model model) {
		model.addAttribute("institutionEntry", new InstitutionEntries());
		List<Institution> suppliers = institutionRepository.getAllSuppliers();
		model.addAttribute("suppliers", suppliers);
		return "institutions_entries_new";
	}

	@PostMapping("/institutions_entries_new")
	public String saveinstitutionsEntriesNew(Model model, InstitutionEntries entries) {
            entries.setDateOfEntry(dateFormatter.currentDateFormmater(LocalDate.now()));
			institutionEntryRepository.saveAndFlush(entries);
		return "redirect:/institutions_entries_new";
	}

	@GetMapping("/suppliers_entries_new")
	public String suppliersEntriesNew(Model model) {
		model.addAttribute("suppliersEntries", new SuppliersEntries());
		model.addAttribute("institutions", institutionRepository.getAllInstitutions());
		return "suppliers_entries_new";
	}

	@PostMapping("/attachment")
	public String newattAchment(Model model, SuppliersEntries suppliers, @RequestParam("file") MultipartFile file[],
			RedirectAttributes ra, @RequestParam(value = "dutyExemptionRadio", required = false) String dutyExemptionRadio) {
		List<Documents> docs = new ArrayList<>();
		if (file.length == 0) {
			ra.addFlashAttribute("message", "Please select a file to upload");
		}

		try {
			for (int i = 0; i < file.length; i++) {
				byte[] bytes = file[i].getBytes();
				Path path = Paths.get(UPLOADED_FOLDER + file[i].getOriginalFilename());
				Files.write(path, bytes);

				Documents newDoc = new Documents();
				newDoc.setDocumentLocation(UPLOADED_FOLDER + "/" + file[i].getOriginalFilename());
				Documents doc = DocumentsRepository.saveAndFlush(newDoc);
				docs.add(doc);
				suppliers.setDocuments(docs);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			suppliersEntryRepository.saveAndFlush(suppliers);
		}

		return "redirect:/attach_docs_suppl";
	}

	@PostMapping("/suppliers_entries_new")
	public String saveSuppliersEntriesNew(Model model, SuppliersEntries suppliers,
			@RequestParam("file") MultipartFile file[], RedirectAttributes ra, 
			@RequestParam(value="dutyExemptionRadio", required=false) String dutyExemptionRadio) {
     List<Documents> docs= new ArrayList<>();
		if (file.length==0) {
            ra.addFlashAttribute("message", "Please select a file to upload");
        }
		
        try {
        	for(int i=0; i< file.length; i++)
        	{
        		byte[] bytes = file[i].getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file[i].getOriginalFilename());
                Files.write(path, bytes);
                
                Documents newDoc =new Documents();
                newDoc.setDocumentLocation(UPLOADED_FOLDER + "/" + file[i].getOriginalFilename());
                Documents doc = DocumentsRepository.saveAndFlush(newDoc);
                docs.add(doc);          
                suppliers.setDocuments(docs);       
        	}

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
          suppliers.setDateOfEntry(dateFormatter.currentDateFormmater(LocalDate.now()));
        	suppliersEntryRepository.saveAndFlush(suppliers);
        }
        return  "redirect:/suppliers_entries_new";
	}

	@GetMapping("/suppliers_entries")
	public String suppliersEntries(Model model) {
		List<SuppliersEntries> suppliersEntries = suppliersEntryRepository.findAll();
		model.addAttribute("suppliersEntries", suppliersEntries);
		return "suppliers_entries";
	}

	@GetMapping("/attach_docs_suppl")
	public String attachDocsSuppl(Model model) {
		List<InstitutionEntries> institutionEntries = institutionEntryRepository.findAll();
		model.addAttribute("institutionEntries", institutionEntries);
		return "attach_docs_suppl";
	}

	@GetMapping("/attach_docs_inst")
	public String attachDocsInst(Model model) {
		List<InstitutionEntries> institutionEntries = institutionEntryRepository.findAll();
		model.addAttribute("institutionEntries", institutionEntries);
		return "attach_docs_inst";
	}
	
	@PostMapping("/attach_docs_inst")
	public String saveInstitutionDocuments(Model model, @RequestParam("file") MultipartFile file[], 
			RedirectAttributes ra) {
		List<Documents> docs = new ArrayList<>();
		if (file.length == 0) {
			ra.addFlashAttribute("message", "Please select a file to upload");
		}

		try {
			for (int i = 0; i < file.length; i++) {
				byte[] bytes = file[i].getBytes();
				Path path = Paths.get(UPLOADED_FOLDER + file[i].getOriginalFilename());
				Files.write(path, bytes);
				Documents newDoc = new Documents();
				newDoc.setDocumentLocation(UPLOADED_FOLDER + "/" + file[i].getOriginalFilename());
				Documents doc = DocumentsRepository.saveAndFlush(newDoc);
				docs.add(doc);
				//suppliers.setDocuments(docs);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//suppliersEntryRepository.saveAndFlush(suppliers);
		}
		return "redirect:/institutions_entries";
	}

}
