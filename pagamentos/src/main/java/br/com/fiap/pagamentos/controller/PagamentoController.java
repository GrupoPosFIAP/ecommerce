package br.com.fiap.pagamentos.controller;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkraft.springfilter.boot.Filter;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.service.PagamentoService;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import lombok.Data;

@Data
@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;
    
    @PostMapping
    @AuthenticationRequired
    public PagamentoDto executePayment(@RequestBody PagamentoDto paymentDto) {
        return pagamentoService.executePayment(paymentDto);
    }

    /*
     * Para uso consultar: https://github.com/turkraft/springfilter
     */
    @GetMapping("/search")
    @AuthenticationRequired
    public List<PagamentoDto> search(@Filter Specification<Pagamento> spec) {
        return pagamentoService.search(spec);
    }
}
