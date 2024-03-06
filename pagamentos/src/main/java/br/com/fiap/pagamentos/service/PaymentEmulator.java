package br.com.fiap.pagamentos.service;

import org.springframework.stereotype.Component;

import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;

@Component
public class PaymentEmulator {

    public StatusPagamento executePayment(PagamentoDto dto) {
        return Math.random() > 0.2d ? StatusPagamento.CONFIRMED : StatusPagamento.REFUSED;
    }
    
}
