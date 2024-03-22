package br.com.fiap.pagamentos.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.fiap.pagamentos.domain.Pagamento;
import br.com.fiap.pagamentos.dto.PagamentoDto;
import lombok.Data;

@Data
@Component
public class PagamentoMapper implements Mapper<PagamentoDto, Pagamento> {

    private final ModelMapper modelMapper;

    @Override
    public PagamentoDto toDto(Pagamento entity) {
        return modelMapper.map(entity, PagamentoDto.class);
    }

    @Override
    public Pagamento toEntity(PagamentoDto dto) {
        return modelMapper.map(dto, Pagamento.class);
    }
    
}
