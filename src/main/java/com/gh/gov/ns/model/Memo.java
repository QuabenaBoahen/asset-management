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
public class Memo implements Serializable{
	
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
	public String getInstitutionId() {
		return institutionId;
	}
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTopOfficialContact() {
		return topOfficialContact;
	}
	public void setTopOfficialContact(String topOfficialContact) {
		this.topOfficialContact = topOfficialContact;
	}
	public String getTopOfficialContactInfo() {
		return topOfficialContactInfo;
	}
	public void setTopOfficialContactInfo(String topOfficialContactInfo) {
		this.topOfficialContactInfo = topOfficialContactInfo;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
