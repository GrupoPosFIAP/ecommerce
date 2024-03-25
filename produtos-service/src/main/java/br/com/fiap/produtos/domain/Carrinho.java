package br.com.fiap.produtos.domain;


import br.com.fiap.produtos.dto.ProdutoCarrinhoDTO;
import br.com.fiap.produtos.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "carrinho")
@EqualsAndHashCode(of = "id")
public class Carrinho {

    @Id
    private String id;

    private String userId;

    private List<ProdutoCarrinhoDTO> produtos;

    private BigDecimal valorTotal;

    private Status status;

    public void addProduto(ProdutoCarrinhoDTO produto) {
        this.produtos.add(produto);
    }
}
