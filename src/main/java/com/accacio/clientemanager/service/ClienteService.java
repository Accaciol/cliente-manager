package com.accacio.clientemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	private final ClienteRepository repositorio;

    public ClienteService(ClienteRepository repositorio) {
        this.repositorio = repositorio;
    }
    
    public void alterarCliente(Cliente cliente) {
		String sql = "UPDATE CLIENTE SET CPF = ?, EMAIL=?, NOME=?, SENHA=? WHERE ID= ?";
		try {
			jdbcTemplate.update(sql, cliente.getNome(), cliente.getCpf(), cliente.getEmail(), cliente.getEmail(),
					cliente.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public Cliente criarCliente(Cliente cliente) {
		return repositorio.save(cliente);
    }
    
	public List<Cliente> findAllNative() {
		return repositorio.findAllNative();
	}
	
	public Cliente findOnlyOneNative(Integer id) {
		return repositorio.findOnlyOneNative(id);
	}

	public void removeCliente(Integer id) {
		repositorio.deleteById(id);
	}

}
