package com.accacio.clientemanager.controller;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accacio.clientemanager.mock.GeradorMassa;
import com.accacio.clientemanager.model.Cliente;
import com.accacio.clientemanager.service.ClienteService;

@ExtendWith(value = { MockitoExtension.class})
public class ClienteControllerUnitTests {

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
	
	
	
}


