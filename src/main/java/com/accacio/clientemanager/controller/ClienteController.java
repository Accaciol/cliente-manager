package com.accacio.clientemanager.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.repository.ClienteRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllClients(EntityManager entityManager) {
		TypedQuery<Cliente> query = entityManager.createQuery("SELECT * FROM CLIENTE ", Cliente.class);
		
		List<Cliente> cliente = query.getResultList();
		
		System.out.println(cliente.get(1));
		System.out.println(cliente.get(2));
		
		try {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 @GetMapping("/validarUsuario")
	    public String validarUsuario(Authentication authentication) {

	        String userName = authentication.getName();

	        return "Spring Security In-memory Authentication Example - Welcome " + userName;
	    }
	
	
	@GetMapping("/isAlive")
	public ResponseEntity<List<Cliente>> isAlive(@RequestParam(required = false) String title) {
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
