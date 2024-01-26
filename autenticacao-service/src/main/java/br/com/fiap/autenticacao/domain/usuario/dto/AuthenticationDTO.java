package br.com.fiap.autenticacao.domain.usuario.dto;

public record AuthenticationDTO(
        String username,
        String password
) {
}
