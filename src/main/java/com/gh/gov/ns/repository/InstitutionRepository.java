package com.gh.gov.ns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gh.gov.ns.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, String>{
	@Query(value = "SELECT * FROM institution WHERE name = ?1", nativeQuery = true)
	Institution findInstitutionByName(String name);

}
