package br.com.fiap.produtos.service;

;


import br.com.fiap.produtos.domain.Pagamento;
import br.com.fiap.produtos.dto.PagamentoDto;
import br.com.fiap.produtos.enums.StatusPagamento;
import br.com.fiap.produtos.mapping.PagamentoMapper;
import br.com.fiap.produtos.repository.PagamentoRepository;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Service
@Transactional
public class PagamentoService {
    
    private final PagamentoMapper mapper;

    private final PagamentoRepository repository;

    private final PaymentEmulator paymentEmulator;

    public PagamentoDto executePayment(PagamentoDto paymentDto) {
        StatusPagamento paymentStatus = paymentEmulator.executePayment(paymentDto);
        
        var payment = mapper.toEntity(paymentDto);
        payment.setStatusPagamento(paymentStatus);

        var entity = repository.save(payment);

        return mapper.toDto(entity);
    }

    public List<PagamentoDto> search(Specification<Pagamento> spec) {
        
        return repository.findAll(spec)
            .stream()
            .map(mapper::toDto)
            .collect(toList());
    }
}
