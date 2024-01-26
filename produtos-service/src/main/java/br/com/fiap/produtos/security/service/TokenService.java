package br.com.fiap.produtos.security.service;


import br.com.fiap.autenticacao.domain.usuario.Usuario;

public interface TokenService {

    String generateToken(Usuario usuario);

    String validateToken(String token);
}
