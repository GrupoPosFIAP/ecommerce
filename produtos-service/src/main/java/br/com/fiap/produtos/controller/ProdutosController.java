package br.com.fiap.produtos.controller;

import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @GetMapping
    public String consultar() {
        return "Consulta de produtos";
    }

    @GetMapping("/comprar")
    @AuthenticationRequired
    public String comprarItem() {
        return "Comprar Item [USER]";
    }

    @GetMapping("/editar")
    @AuthenticationRequired
    @RolesAllowed("ROLE_ADMIN")
    public String editarPreco() {
        return "Editar preços [ADMIN]";
    }
}
