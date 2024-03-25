package br.com.fiap.produtos.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "produtos")
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotBlank(message = "Nome do produto não pode ser nulo ou vazio.")
    private String nome;

    @NotBlank(message = "Descrição do produto não pode ser nula ou vazia.")
    private String descricao;

    @NotBlank(message = "Estoque não pode ser nulo ou vazio.")
    @Min(value = 0, message = "Estoque não pode ser negativo.")
    private Long quantidadeEstoque;

    @NotBlank(message = "Valor não pode ser nulo ou vazio.")
    @Min(value = 0, message = "Valor não pode ser negativo.")
    private BigDecimal valor;

    private List<String> imagens;

}
