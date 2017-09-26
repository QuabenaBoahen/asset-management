package com.gh.gov.ns.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class InstitutionEntries implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String entryId;
	private String typeOfVehicle;
	private String chassisNumber;
	private String engineNumber;
	private String dateOfEntry;
	private String manufYear;
	private String dateReceived;
	private String companyReceivedFrom;
	private int status;
	private String reasonIfAuctioned;

}
