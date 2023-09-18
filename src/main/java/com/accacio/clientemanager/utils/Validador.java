package com.accacio.clientemanager.utils;

import com.accacio.clientemanager.model.Cliente;

public class Validador {

	public static boolean validadorCliente(Cliente cliente) {
	    
	    if(validaCPF(cliente) || validaEmail(cliente) || validaSenha(cliente) ||
	    		validaNome(cliente)) {
	    	return  false;
	    }
	    return true;
	}

	
	public static boolean validaCPF(Cliente cliente){
		String cpf = cliente.getCpf();

		if (cpf.isEmpty() || cpf.isBlank() || cpf == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validaEmail(Cliente cliente){
		String email = cliente.getEmail();

		if (email.isEmpty() || email.isBlank() || email == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validaSenha(Cliente cliente) throws RuntimeException {
		String senha = cliente.getSenha();

		if (senha.isEmpty() || senha.isBlank() || senha == null) {
			return false;
		}
		return true;
	}
	
	public static boolean validaNome(Cliente cliente) throws RuntimeException {
		String nome = cliente.getNome();

		if (nome.isEmpty() || nome.isBlank() || nome == null) {
			return false;
		}
		return true;
	}
}
