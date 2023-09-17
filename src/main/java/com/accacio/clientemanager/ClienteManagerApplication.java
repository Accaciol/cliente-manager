package com.accacio.clientemanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.accacio.clientemanager.controller.GeradorMassa;
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
		
	}


    @Bean
    static JdbcTemplate jdbcTemplate(DataSource dataSource) {
	       return new JdbcTemplate(dataSource);
	    }

	
}
