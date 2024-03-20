package br.com.fiap.carrinho.controler;

import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @GetMapping
    public String consultar() {
        return "Consulta de carrinho";
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
