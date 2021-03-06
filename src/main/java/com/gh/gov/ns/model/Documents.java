package com.gh.gov.ns.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Documents implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String documentId;
	private String documentLocation;
	//@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	private int institutionTrxId;
	
	//@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	private int suppliersTrxId;

}
