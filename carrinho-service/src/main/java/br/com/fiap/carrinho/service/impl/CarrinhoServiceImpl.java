package br.com.fiap.carrinho.service.impl;
import br.com.fiap.carrinho.dto.CarrinhoDTO;
import br.com.fiap.carrinho.enums.Status;
import br.com.fiap.carrinho.repository.CarrinhoRepository;
import br.com.fiap.carrinho.service.CarrinhoService;
import br.com.fiap.produtos.dto.ProdutoDTO;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarrinhoServiceImpl implements CarrinhoService {

    private final CarrinhoRepository carrinhoRepository;

    @Override
    public CarrinhoDTO save(CarrinhoDTO dto) {
        Carrinho carrinho = new Carrinho();
        carrinho.setStatus(String.valueOf(dto.getStatus()));
        return toDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public List<CarrinhoDTO> findAll() {
        return  carrinhoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarrinhoDTO findByUserId(String id) {
        Carrinho carrinho = (Carrinho) carrinhoRepository.findByUserId(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        verifyStatusCarrinho(id);
        return toDTO(carrinho);
    }

    @Override
    public CarrinhoDTO update(String id, CarrinhoDTO dto) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        carrinho.setStatus(String.valueOf(dto.getStatus()));
        return toDTO(carrinhoRepository.save(carrinho));
    }

    @Override
    public void delete(String id) {
        carrinhoRepository.deleteById(id);
    }

    @Override
    public Carrinho verifyStatusCarrinho(String id) {
        Carrinho carrinho = carrinhoRepository.findById(id).orElseThrow(() -> new RuntimeException("Carrinho não encontrado."));
        if (carrinho.getStatus().equals("FINALIZADO")) {
            throw new RuntimeException("Carrinho já finalizado.");
        }
        return carrinho;
    }

    @Override
    public CarrinhoDTO addProduct(String id, List<ProdutoDTO> products) {
        Carrinho carrinho = verifyStatusCarrinho(id);
        carrinho.setNomeProduto(products);
        carrinho.setStatus("EM_ANDAMENTO");
        double sum = 0.0;
        for (ProdutoDTO product : products) {
            @Min(value = 0, message = "Valor não pode ser negativo.")
            BigDecimal valor = product.getValor();
            sum += valor;
        }
        carrinho.setValorTotal(sum;
        return toDTO(carrinhoRepository.save(carrinho));
    }


    private CarrinhoDTO toDTO(Carrinho carrinho) {
        return CarrinhoDTO.builder()
                .id(carrinho.getId())
                .status(Status.valueOf(carrinho.getStatus()))
                .build();
    }
}
