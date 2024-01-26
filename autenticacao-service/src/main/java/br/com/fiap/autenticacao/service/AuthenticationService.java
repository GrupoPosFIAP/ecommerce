package br.com.fiap.autenticacao.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService extends UserDetailsService {

    UserDetails loadUserByUsername(String username);

}
