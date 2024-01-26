package br.com.fiap.cadastro.security.service;

import br.com.fiap.cadastro.domain.usuario.Usuario;

public interface TokenService {

    String generateToken(Usuario usuario);

    String validateToken(String token);
}
