package br.com.fiap.cadastro.service.impl;

import br.com.fiap.cadastro.repository.CadastroRepository;
import br.com.fiap.cadastro.service.AuthenticationService;
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
