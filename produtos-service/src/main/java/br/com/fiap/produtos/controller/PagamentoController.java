package br.com.fiap.produtos.controller;


import br.com.fiap.produtos.domain.Pagamento;
import br.com.fiap.produtos.dto.PagamentoDto;
import br.com.fiap.produtos.service.PagamentoService;
import br.com.fiap.rest.configuration.api.security.annotations.AuthenticationRequired;
import com.turkraft.springfilter.boot.Filter;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
