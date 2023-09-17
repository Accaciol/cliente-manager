package com.accacio.clientemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accacio.clientemanager.model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
