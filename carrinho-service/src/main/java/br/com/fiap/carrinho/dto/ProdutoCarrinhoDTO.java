package br.com.fiap.carrinho.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class ProdutoCarrinhoDTO {

    private String idProduto;

    private String produto;

    private BigDecimal valor;

    private Long quantidade;
}
