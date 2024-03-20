package br.com.fiap.carrinho.controler;

import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @GetMapping
    @AuthenticationRequired
    public String consultar(@AuthenticationPrincipal Usuario usuario) {
        return "Consulta de carrinho" + usuario.getUsername();
    }

    @GetMapping("/adicionar")
    public String adicionarItem() {
        return "Adicionar Item";
    }

    @GetMapping("/editar")
    public String removerItem() {
        return "Remover Item";
    }

    @GetMapping("/finalizar")
    public String finalizarCompra() {
        return "Finalizar Compra";
    }

}
