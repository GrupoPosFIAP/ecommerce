package br.com.fiap.pagamentos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.fiap.pagamentos.enumeration.FormaPagamento;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;

public record PagamentoDto(
    String cartId,
    StatusPagamento statusPagamento,
    FormaPagamento formaPagamento,
    BigDecimal value,
    LocalDateTime timestamp,
    String pagadorNome,
    String pagadorDoc,
    String password,
    String paymentData
) {}
