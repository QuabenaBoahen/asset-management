package com.gh.gov.ns.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gh.gov.ns.model.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo, String>{
	
	@Query(value = "SELECT * FROM memo WHERE  ", nativeQuery = true)
	List<Memo> inboxMemo(String userId);

}
