package com.accacio.clientemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.accacio.clientemanager.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	@Query(value = "SELECT * FROM Cliente", nativeQuery = true)
	List<Cliente> findAllNative();
		
	
	}
