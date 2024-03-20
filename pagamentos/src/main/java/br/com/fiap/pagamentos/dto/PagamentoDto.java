package br.com.fiap.pagamentos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.fiap.pagamentos.enumeration.FormaPagamento;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
