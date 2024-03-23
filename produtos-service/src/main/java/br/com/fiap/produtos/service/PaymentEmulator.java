package br.com.fiap.produtos.service;


import br.com.fiap.produtos.dto.PagamentoDto;
import br.com.fiap.produtos.enums.StatusPagamento;
import org.springframework.stereotype.Component;

@Component
public class PaymentEmulator {

    public StatusPagamento executePayment(PagamentoDto dto) {
        return Math.random() > 0.2d ? StatusPagamento.CONFIRMED : StatusPagamento.REFUSED;
    }
    
}
