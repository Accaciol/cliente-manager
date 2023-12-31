package com.accacio.clientemanager.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class UserDetailsService {

	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails Lucas = User.builder().username("Lucas").password(passwordEncoder().encode("password"))
				.roles("USER").build();

		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(Lucas, admin);
	}

	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
