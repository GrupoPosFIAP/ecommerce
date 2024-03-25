package br.com.fiap.pagamentos.service;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.dto.PagamentoDto;
import br.com.fiap.pagamentos.enumeration.StatusPagamento;
import br.com.fiap.pagamentos.mapping.PagamentoMapper;
import br.com.fiap.pagamentos.repository.PagamentoRepository;
import br.com.fiap.pagamentos.rest.ProdutoRestClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
@Service
@Transactional
@Slf4j
public class PagamentoService {
    
    private final PagamentoMapper mapper;

    private final PagamentoRepository repository;

    private final PaymentEmulator paymentEmulator;

    private final ProdutoRestClient produtoRestClient;

    ObjectMapper objectMapper = new ObjectMapper();

    public PagamentoDto executePayment(PagamentoDto paymentDto, String auth) throws JsonProcessingException {
        StatusPagamento paymentStatus = paymentEmulator.executePayment(paymentDto);

        if(StatusPagamento.CONFIRMED.equals(paymentStatus)) {
            Object carrinho = produtoRestClient.criarCarrinho(auth);
            log.info("carrinho criado: " + objectMapper.writeValueAsString(carrinho));
        }
        
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
