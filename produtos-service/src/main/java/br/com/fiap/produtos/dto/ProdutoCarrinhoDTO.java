package br.com.fiap.produtos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProdutoCarrinhoDTO {

    private String idProduto;

    private String produto;

    private BigDecimal valor;

    private Long quantidade;
}
