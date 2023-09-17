package com.accacio.clientemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.repository.ClienteRepository;


@SpringBootApplication
public class ClienteManagerApplication implements CommandLineRunner{

	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ClienteManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Cliente> clientesGerados = geradorClientes();
		clienteRepository.saveAll(clientesGerados);
		
	}

	
	 public static List<Cliente> geradorClientes() {
	        List<Cliente> clientes = new ArrayList<>();

	        // Adicionando o cliente inicial
	        Cliente cli1 = new Cliente(1, "Joao", "14539206700", "email@teste.com", "123456");
	        clientes.add(cli1);

	        // Gerando 20 clientes com dados variados
	        for (int i = 2; i <= 21; i++) {
	            String nome = "Cliente" + i;
	            String cpf = gerarCPF();
	            String email = "cliente" + i + "@example.com";
	            String senha = gerarSenha(8);

	            Cliente cliente = new Cliente(i, nome, cpf, email, senha);
	            clientes.add(cliente);
	        }

	        // Exibindo os clientes
	        for (Cliente cliente : clientes) {
	            System.out.println(cliente);
	        }
	        
	        
			return clientes;
	    }

	 
	 public static String gerarCPF() {
	        Random rand = new Random();

	        int n1 = rand.nextInt(10);
	        int n2 = rand.nextInt(10);
	        int n3 = rand.nextInt(10);
	        int n4 = rand.nextInt(10);
	        int n5 = rand.nextInt(10);
	        int n6 = rand.nextInt(10);
	        int n7 = rand.nextInt(10);
	        int n8 = rand.nextInt(10);
	        int n9 = rand.nextInt(10);

	        int digito1 = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;
	        digito1 = 11 - (digito1 % 11);
	        if (digito1 >= 10) {
	            digito1 = 0;
	        }

	        int digito2 = digito1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;
	        digito2 = 11 - (digito2 % 11);
	        if (digito2 >= 10) {
	            digito2 = 0;
	        }

	        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d", n1, n2, n3, n4, n5, n6, n7, n8, n9, digito1, digito2);
	    }

	 
	 public static String gerarSenha(int comprimento) {
	        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
	        Random random = new Random();
	        StringBuilder senha = new StringBuilder();

	        for (int i = 0; i < comprimento; i++) {
	            int index = random.nextInt(caracteres.length());
	            senha.append(caracteres.charAt(index));
	        }

	        return senha.toString();
	    }

	
}
