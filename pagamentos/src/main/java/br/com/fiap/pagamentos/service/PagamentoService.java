package br.com.fiap.pagamentos.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;
import br.com.fiap.pagamentos.mapping.PagamentoMapper;
import br.com.fiap.pagamentos.repository.PagamentoRepository;
import lombok.Data;

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
