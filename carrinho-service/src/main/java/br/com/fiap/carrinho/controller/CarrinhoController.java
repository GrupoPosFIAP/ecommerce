package br.com.fiap.carrinho.controller;

import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.carrinho.service.CarrinhoService;
import br.com.fiap.produtos.dto.ProdutoDTO;
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

    @PostMapping
    @AuthenticationRequired
    public CarrinhoDTO salvar(@AuthenticationPrincipal Usuario usuario) {
        return this.carrinhoService.save(usuario);
    }

    @GetMapping("/{id}")
    @AuthenticationRequired
    public CarrinhoDTO consultar(@PathVariable("id") String id) {
        return this.carrinhoService.findById(id);
    }

    @PutMapping("/adicionar/{id}")
    public void adicionarItem(@RequestBody ProdutoDTO produto, @PathVariable("id") String id){
        this.carrinhoService.addProduct(produto, id);
    }

    @PutMapping("/editar/{id}")
    public CarrinhoDTO editarListaItens(@PathVariable("id") String id, @RequestBody CarrinhoDTO carrinhoDTO) {
        return carrinhoService.update(id, carrinhoDTO);
    }


}
