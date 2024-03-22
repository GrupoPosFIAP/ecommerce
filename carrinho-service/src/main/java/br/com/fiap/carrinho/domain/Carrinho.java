package br.com.fiap.carrinho.domain;

import br.com.fiap.carrinho.enums.Status;
import br.com.fiap.produtos.domain.Produto;
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

    private List<Produto> produtos;

    private BigDecimal valorTotal;

    private Status status;

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }
}
