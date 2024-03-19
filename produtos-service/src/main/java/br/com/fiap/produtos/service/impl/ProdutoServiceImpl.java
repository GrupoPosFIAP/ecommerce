package br.com.fiap.produtos.service.impl;

import br.com.fiap.produtos.domain.Produto;
import br.com.fiap.produtos.dto.ProdutoDTO;
import br.com.fiap.produtos.repository.ProdutoRepository;
import br.com.fiap.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoDTO save(ProdutoDTO dto) {

        // Converter DTO para entidade
        Produto produto = new Produto();
        produto.setNome(    dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setValor(dto.getValor());
        produto.setImagens(dto.getImagens());

        // Salvando entidade e retornando DTO
        return toDTO(this.produtoRepository.save(produto));
     }

    @Override
    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDTO> findById(String id) {
        return produtoRepository.findById(id).map(this::toDTO);
    }

    @Override
    public ProdutoDTO update(String id, ProdutoDTO dto) {

        // Verificar se produto existe
        Produto produtoAlterado = produtoRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Produto inexistente."));

        // Atualizar campos no DTO
        produtoAlterado.setNome(dto.getNome());
        produtoAlterado.setDescricao(dto.getDescricao());
        produtoAlterado.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produtoAlterado.setValor(dto.getValor());
        produtoAlterado.setImagens(dto.getImagens());

        // Salvar e retornar DTO
        return toDTO(produtoRepository.save(produtoAlterado));
    }

    @Override
    public void delete(String id) {
        produtoRepository.deleteById(id);
    }



    // Método utilitário para converter Produto em ProdutoDTO
    private ProdutoDTO toDTO(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .quantidadeEstoque(produto.getQuantidadeEstoque())
                .valor(produto.getValor())
                .imagens(produto.getImagens())
                .build();
    }
}
