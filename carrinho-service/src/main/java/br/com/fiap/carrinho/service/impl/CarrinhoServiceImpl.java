package br.com.fiap.carrinho.service.impl;

import br.com.fiap.carrinho.domain.Carrinho;
import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.carrinho.dto.ProdutoCarrinhoDTO;
import br.com.fiap.carrinho.enums.Status;
import br.com.fiap.carrinho.repository.CarrinhoRepository;
import br.com.fiap.carrinho.service.CarrinhoService;
import br.com.fiap.produtos.domain.Produto;
import br.com.fiap.produtos.dto.ProdutoDTO;
import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    @Override
    public CarrinhoDTO save(Usuario usuario) {
        Carrinho carrinho = new Carrinho();
        carrinho.setUserId(usuario.getId());
        carrinho.setProdutos(Collections.emptyList());
        carrinho.setValorTotal(BigDecimal.ZERO);
        carrinho.setStatus(Status.VAZIO);
        return toDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public List<CarrinhoDTO> findAll() {
        return carrinhoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarrinhoDTO findById(String id) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        return toDTO(carrinho);
    }

    @Override
    public CarrinhoDTO update(String id, CarrinhoDTO dto) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        carrinho.setStatus(dto.getStatus());
        return toDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public void delete(String id) {
        carrinhoRepository.deleteById(id);
    }

    @Override
    public Carrinho verifyStatusCarrinho(String id) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        if (Status.FINALIZADO.equals(carrinho.getStatus()))
            throw new RuntimeException("Carrinho já finalizado.");
        return carrinho;
    }

    @Override
    public CarrinhoDTO addProduct(ProdutoDTO product, String id) {
        Carrinho carrinho = verifyStatusCarrinho(id);
        carrinho.addProduto(toProdutoCarrinhoDTO(product));
        carrinho.setStatus(Status.EM_ANDAMENTO);
        BigDecimal sum = BigDecimal.ZERO;
        @Min(value = 0, message = "Valor não pode ser negativo.")
        BigDecimal valor = product.getValor();
        sum = sum.add(valor);
        carrinho.setValorTotal(sum);
        return toDTO(carrinhoRepository.save(carrinho));
    }


    private CarrinhoDTO toDTO(Carrinho carrinho) {
        return CarrinhoDTO.builder()
                .id(carrinho.getId())
                .produtos()
                .valorTotal()
                .status(carrinho.getStatus())
                .build();
    }

    private ProdutoCarrinhoDTO toProdutoCarrinhoDTO(Produto produtos) {
        return ProdutoCarrinhoDTO.builder()
                .idProduto(produtos.getId())
                .produto(produtos.getNome())
                .valor(produtos.getValor())
                .build();
    }
}
