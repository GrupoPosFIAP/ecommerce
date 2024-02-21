package br.com.fiap.rest.configuration.api.security.service;


import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;

public interface TokenService {

    String generateToken(Usuario usuario);

    String validateToken(String token);
}
