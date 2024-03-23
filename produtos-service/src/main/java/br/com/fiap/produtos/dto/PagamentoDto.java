package br.com.fiap.produtos.dto;


import br.com.fiap.produtos.enums.FormaPagamento;
import br.com.fiap.produtos.enums.StatusPagamento;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDto {
    private String cartId;
    private StatusPagamento statusPagamento;
    private FormaPagamento formaPagamento;
    private BigDecimal value;
    private LocalDateTime timestamp;
    private String pagadorNome;
    private String pagadorDoc;
    private String password;
    private String paymentData;
}
