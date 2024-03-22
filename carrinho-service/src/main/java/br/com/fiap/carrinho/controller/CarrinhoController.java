package br.com.fiap.carrinho.controller;

import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.carrinho.service.CarrinhoService;
import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping
    @AuthenticationRequired
    public String consultar(@AuthenticationPrincipal Usuario usuario) {
        return this.carrinhoService.findByUserId(usuario.getId()).toString();
    }

    @PutMapping("/adicionar")
    public String adicionarItem() {
        return this.carrinhoService.addProduct().toString();
    }

    @PutMapping("/editar/{id}")
    public CarrinhoDTO editarListaItens(@PathVariable("id") String id, @RequestBody CarrinhoDTO carrinhoDTO) {
        return carrinhoService.update(id, carrinhoDTO);
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
