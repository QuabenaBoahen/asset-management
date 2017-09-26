package com.gh.gov.ns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gh.gov.ns.model.Institution;
import com.gh.gov.ns.web.Letters;

@Repository
public interface LettersRepository extends JpaRepository<Letters, String>{

}
