package br.com.fiap.produtos.mapping;


import br.com.fiap.produtos.domain.Pagamento;
import br.com.fiap.produtos.dto.PagamentoDto;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

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
