package com.gh.gov.ns.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.gh.gov.ns.model.Vehicle;
import com.gh.gov.ns.repository.VehicleRepository;

@Controller
public class VehicleController {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping("/vehicles")
	public String vehicles(Model model){
		List<Vehicle> vehicles=vehicleRepository.findAll();
		model.addAttribute("vehicles", vehicles);
		return "vehicles";
	}
	
	@GetMapping("/vehicles/add")
	public String addVehicles(Model model){
		model.addAttribute("vehicle", new Vehicle());
		return "addvehicle";
	}
	
	@PostMapping("/vehicles")
	public String addVehicle(Vehicle vehicle){
		System.out.println("dfsdf " + vehicle);
		vehicleRepository.saveAndFlush(vehicle);
		return "redirect:/vehicles";
	}	

}
