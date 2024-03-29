package br.com.fiap.produtos.dto;

import br.com.fiap.produtos.enums.Status;
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

    private List<ProdutoCarrinhoDTO> produtos;

    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private Status status;

    public BigDecimal getValorTotal() {
        BigDecimal valorTotal = BigDecimal.ZERO;
        for(ProdutoCarrinhoDTO produtoCarrinhoDTO : produtos) {
            BigDecimal quantidadeProdutos = BigDecimal.valueOf(produtoCarrinhoDTO.getQuantidade());
            BigDecimal valorProduto = produtoCarrinhoDTO.getValor();
            valorTotal = valorTotal.add(valorProduto.multiply(quantidadeProdutos));
        }
        return valorTotal;
    }
}
