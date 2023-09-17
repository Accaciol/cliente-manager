package com.accacio.clientemanager.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PostUpdate;
import javax.persistence.TypedQuery;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.repository.ClienteRepository;
import com.accacio.clientemanager.service.ClienteService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	
	@Autowired
	ClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClients(Authentication authentication) {
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		try {
			cliente = clienteService.findAllNative();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getOnlyOneClient(Authentication authentication,
			@PathVariable Integer id) {
		
		Cliente cliente = new Cliente();
		try {
			cliente = clienteService.findOnlyOneNative(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cliente);
		
		try {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public void criarUsuario(@RequestBody Cliente cliente) {
		clienteService.criarCliente(cliente);
	}

	@DeleteMapping("/{id}")
	public void apagarUsuario(@PathVariable Integer id) {
		clienteService.removeCliente(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizaParcialmenteCliente(@RequestBody Cliente cliente){
		clienteService.alterarCliente(cliente);
		
		return null;
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
