package br.com.fiap.pagamentos.mapping;

public interface Mapper<DTO, ENTITY> {
    

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
