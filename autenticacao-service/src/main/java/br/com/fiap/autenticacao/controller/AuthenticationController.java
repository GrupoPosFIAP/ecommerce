package br.com.fiap.autenticacao.controller;


import br.com.fiap.autenticacao.domain.usuario.dto.AuthenticationDTO;
import br.com.fiap.autenticacao.domain.usuario.dto.AuthenticationResponseDTO;
import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import br.com.fiap.rest.configuration.api.security.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public AuthenticationResponseDTO login(@RequestBody @Valid AuthenticationDTO user) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(user.username(), user.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return new AuthenticationResponseDTO(token);
    }

}
