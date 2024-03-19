package br.com.fiap.produtos.service;

import br.com.fiap.produtos.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoDTO save(ProdutoDTO dto);

    Optional<ProdutoDTO> findById(String id);

    List<ProdutoDTO> findAll();

    ProdutoDTO update(String id, ProdutoDTO dto);

    void delete(String id);

}