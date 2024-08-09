package com.sunBank.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunBank.security.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole,Long>{
	AppRole findAppRoleByRoleName(String rolename);
}
