package br.com.fiap.produtos.service.impl;

import br.com.fiap.produtos.domain.Carrinho;
import br.com.fiap.produtos.dto.CarrinhoDTO;
import br.com.fiap.produtos.dto.ProdutoCarrinhoDTO;
import br.com.fiap.produtos.dto.ProdutoDTO;
import br.com.fiap.produtos.enums.Status;
import br.com.fiap.produtos.repository.CarrinhoRepository;
import br.com.fiap.produtos.service.CarrinhoService;
import br.com.fiap.rest.configuration.api.domain.usuario.Usuario;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
        addProdutoToCarrinho(carrinho, product);
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
                .produtos(carrinho.getProdutos())
                .valorTotal(carrinho.getValorTotal())
                .status(carrinho.getStatus())
                .build();
    }

    private void addProdutoToCarrinho(Carrinho carrinho, ProdutoDTO produto) {

        Optional<ProdutoCarrinhoDTO> produtoCarrinho = carrinho.getProdutos()
                .stream()
                .filter(
                        produtoCarrinhoDTO -> produtoCarrinhoDTO.getIdProduto().equals(produto.getId()))
                .findFirst();

        if (produtoCarrinho.isPresent()) {
            produtoCarrinho.get().setQuantidade(produtoCarrinho.get().getQuantidade() + 1);
        } else {
            carrinho.addProduto(
                    ProdutoCarrinhoDTO.builder()
                            .idProduto(produto.getId())
                            .valor(produto.getValor())
                            .produto(produto.getNome())
                            .quantidade(1L)
                            .build()
            );
        }
    }
}
