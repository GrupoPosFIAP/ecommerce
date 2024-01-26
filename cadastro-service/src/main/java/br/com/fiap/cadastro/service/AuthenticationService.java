package br.com.fiap.cadastro.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

}
