package br.com.fiap.carrinho.domain;

import br.com.fiap.produtos.domain.Produto;
import br.com.fiap.produtos.dto.ProdutoDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    private List<ProdutoDTO> nomeProduto;

    private List<Long> quantidade;

    private List<Double> valor;

    private Double valorTotal;

    private String status;

    private String dataCriacao;

    private String dataAtualizacao;

    private String dataFinalizacao;
}
