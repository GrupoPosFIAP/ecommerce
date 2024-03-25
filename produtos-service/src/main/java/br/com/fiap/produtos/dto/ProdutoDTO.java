package br.com.fiap.produtos.dto;

import br.com.fiap.produtos.domain.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
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
public class ProdutoDTO {

    private String id;

    @NotBlank(message = "Nome do produto não pode ser nulo ou vazio.")
    private String nome;

    @NotBlank(message = "Descrição do produto não pode ser nula ou vazia.")
    private String descricao;

    @Min(value = 0, message = "Estoque não pode ser negativo.")
    private Long quantidadeEstoque;

    @Min(value = 0, message = "Valor não pode ser negativo.")
    private BigDecimal valor;

    private List<String> imagens;

    public Produto toEntity() {
        return Produto.builder()
                .id(this.id)
                .nome(this.nome)
                .descricao(this.descricao)
                .quantidadeEstoque(this.quantidadeEstoque)
                .valor(this.valor)
                .imagens(this.imagens)
                .build();
    }
}