package br.com.fiap.pagamentos.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.service.PagamentoService;
import lombok.Data;

@Data
@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;
    
    @PostMapping
    // @AuthenticationRequired
    public PagamentoDto executePayment(@RequestBody PagamentoDto paymentDto) {
        return pagamentoService.executePayment(paymentDto);
    }

    @GetMapping("/{id}")
    // @AuthenticationRequired
    public PagamentoDto findById(@PathVariable UUID id) {
        return pagamentoService.findById(id);
    }
}
