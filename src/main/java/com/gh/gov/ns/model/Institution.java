package com.gh.gov.ns.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Institution implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String institutionId;
	private String name;
	private String address;
	private String email;
	private String phone;
	private String topOfficialContact;
	private String topOfficialContactInfo;
	@OneToMany(mappedBy="institution", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<User> users;

}
