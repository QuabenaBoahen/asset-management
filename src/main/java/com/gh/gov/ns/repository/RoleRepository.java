package com.gh.gov.ns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gh.gov.ns.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
	
	@Query("select roleId, roleName from Role where roleName = :role_name")
	public Role findRoleByRoleName(@Param("role_name") String role_name);

}
