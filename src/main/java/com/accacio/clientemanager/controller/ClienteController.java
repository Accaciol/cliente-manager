package com.accacio.clientemanager.controller;


import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.accacio.clientemanager.service.ClienteService;
import com.accacio.clientemanager.utils.Validador;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	
	@Autowired
	ClienteService clienteService;
	
	Validador validador;

	@GetMapping
	public ResponseEntity<List<Cliente>> getAllClients(Authentication authentication) {
		
		List<Cliente> cliente = new ArrayList<Cliente>();
		try {
			cliente = clienteService.findAllNative();
		} catch (Exception e) {
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
			e.printStackTrace();
		}
		
		try {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) throws Exception {
		boolean clientevalido = validador.validadorCliente(cliente);
		if(clientevalido) {
			clienteService.criarCliente(cliente);
		}
		try {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> apagarUsuario(@PathVariable Integer id) {
		clienteService.removeCliente(id);
		
		try {
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente){
		clienteService.alterarCliente(cliente);
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
