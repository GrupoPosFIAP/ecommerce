package br.com.fiap.carrinho.dto;

import br.com.fiap.carrinho.enums.Status;
import br.com.fiap.produtos.dto.ProdutoDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarrinhoDTO {

    private String id;

    private String userId;

    private List<ProdutoDTO> nomeProduto;

    private BigDecimal valorTotal;

    private BigDecimal valorFinal;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String dataCriacao;

    private String dataAtualizacao;

    private String dataFinalizacao;
}
