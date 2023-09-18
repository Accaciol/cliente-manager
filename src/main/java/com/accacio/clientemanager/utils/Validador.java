package com.accacio.clientemanager.utils;

import com.accacio.clientemanager.model.Cliente;

public class Validador {

	public boolean validadorCliente(Cliente cliente) throws Exception {

		if(validaCPF(cliente)) {
			throw new Exception("CPF não foi preenchido.");
		}if(validaEmail(cliente)) {
			throw new Exception("Email não foi preenchido.");
		}if(validaSenha(cliente)) {
			throw new Exception("Senha não foi preenchido.");
		}if(validaNome(cliente)) {
			throw new Exception("Nome não foi preenchido.");
		}
		
		return true;
	}
	
	public boolean validaCPF(Cliente cliente) throws Exception {
		String cpf = cliente.getCpf();

		if (cpf.isEmpty() || cpf.isBlank()) {
			return true;
		}
		return false;
	}
	
	public boolean validaEmail(Cliente cliente) throws Exception {
		String email = cliente.getEmail();

		if (email.isEmpty() || email.isBlank()) {
			return true;
		}
		return false;
	}
	
	public boolean validaSenha(Cliente cliente) throws Exception {
		String senha = cliente.getSenha();

		if (senha.isEmpty() || senha.isBlank()) {
			return true;
		}
		return false;
	}
	
	public boolean validaNome(Cliente cliente) throws Exception {
		String nome = cliente.getNome();

		if (nome.isEmpty() || nome.isBlank()) {
			return true;
		}
		return false;
	}
}
