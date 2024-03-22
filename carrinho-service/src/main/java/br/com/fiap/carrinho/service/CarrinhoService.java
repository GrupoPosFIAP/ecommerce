package br.com.fiap.carrinho.service;

import br.com.fiap.carrinho.domain.Carrinho;
import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.produtos.dto.ProdutoDTO;

import java.util.List;

public interface CarrinhoService {

    CarrinhoDTO save(CarrinhoDTO dto);

    CarrinhoDTO findByUserId(String id);

    CarrinhoDTO update(String id, CarrinhoDTO dto);

    List<CarrinhoDTO> findAll();

    void delete(String id);

    Carrinho verifyStatusCarrinho(String id);

    CarrinhoDTO addProduct(String id, List<ProdutoDTO> products);

}
