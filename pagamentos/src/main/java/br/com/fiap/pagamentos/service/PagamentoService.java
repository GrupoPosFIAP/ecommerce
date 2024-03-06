package br.com.fiap.pagamentos.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;
import br.com.fiap.pagamentos.mapping.PagamentoMapper;
import br.com.fiap.pagamentos.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
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

    public PagamentoDto findById(UUID id) {
        var entity = repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Payment not found"));

        log.info("Pagamento encontrado:", entity.getId());

        return mapper.toDto(entity);
    }

    public List<PagamentoDto> search(PagamentoDto dto) {
        var entity = mapper.toEntity(dto);
        Example<Pagamento> example = Example.of(entity);

        return repository
            .findAll(example)
            .stream()
            .map(mapper::toDto)
            .collect(toList());
    }
}
