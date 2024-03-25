package br.com.fiap.carrinho.service;

import br.com.fiap.carrinho.domain.Carrinho;
import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.produtos.dto.ProdutoDTO;
import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;

import java.util.List;

public interface CarrinhoService {

    CarrinhoDTO save(Usuario usuario);

    CarrinhoDTO findById(String id);

    CarrinhoDTO update(String id, CarrinhoDTO dto);

    List<CarrinhoDTO> findAll();

    void delete(String id);

    Carrinho verifyStatusCarrinho(String id);

    CarrinhoDTO addProduct(ProdutoDTO product, String id);

}
