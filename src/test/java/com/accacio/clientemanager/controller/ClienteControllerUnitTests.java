package com.accacio.clientemanager.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accacio.clientemanager.mock.GeradorMassa;
import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.service.ClienteService;

@ExtendWith(value = { MockitoExtension.class})
public class ClienteControllerUnitTests {

	@Spy
	@InjectMocks
	private ClienteController controller;
	@Mock
	private ClienteService service;
	
	@Test
	public void getAllClients(){
		List<Cliente> cliente = GeradorMassa.geradorClientes();
		
		when(service.findAllNative()).thenReturn(cliente);
		
		List<Cliente> clienteT = controller.getAllClients(null).getBody();
		
		Assertions.assertNotNull(clienteT);
		Assertions.assertFalse(clienteT.isEmpty());
		Assertions.assertEquals(cliente.size(), clienteT.size());
	}
	
	
	@Test
	public void getOnlyOneClient(){
		List<Cliente> cliente = GeradorMassa.geradorClientes();
		
		when(service.findOnlyOneNative(0)).thenReturn(cliente.get(0));
		
		Cliente clienteT = controller.getOnlyOneClient(null,0).getBody();
		
		Assertions.assertNotNull(clienteT);
		Assertions.assertEquals(cliente.get(0).getId().intValue(), clienteT.getId().intValue());
	}
	
	@Test
	public void criaUsuario() {
		Cliente cli1 = new Cliente(0, "Joao", "14539206700", "email@teste.com", "123456");
		
		when(service.criarCliente(cli1)).thenReturn(cli1);
		Cliente clienteCriado = controller.criarCliente(cli1).getBody();
		Assertions.assertNotNull(clienteCriado);
		Assertions.assertFalse(clienteCriado.getNome().isEmpty());
		
	}

	@Test
	public void apagarUsuario() {
		List<Cliente> cliente = GeradorMassa.geradorClientes();
		
		doNothing().when(service).removeCliente(0);
		controller.apagarUsuario(0);
		verify(controller, times(1)).apagarUsuario(0);
	}
	
	@Test
	public void alterarCliente() {
		Cliente cli1 = new Cliente(0, "Joao", "14539206700", "email@teste.com", "123456");
		
		doNothing().when(service).alterarCliente(cli1);
		controller.alterarCliente(cli1);
		verify(controller, times(1)).alterarCliente(cli1);
	}
	
}



