package br.com.fiap.autenticacao.security.service;


import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;

public interface TokenService {

    String generateToken(Usuario usuario);

}
