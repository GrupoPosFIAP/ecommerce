package br.com.fiap.autenticacao.service.impl;

import br.com.fiap.autenticacao.service.AuthenticationService;
import br.com.fiap.rest.configuration.api.security.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final CadastroRepository cadastroRepository;

    @Autowired
    public AuthenticationServiceImpl(CadastroRepository cadastroRepository) {
        this.cadastroRepository = cadastroRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return cadastroRepository.findByUsername(username);
    }
}
