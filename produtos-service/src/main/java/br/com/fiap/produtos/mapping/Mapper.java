package br.com.fiap.produtos.mapping;

public interface Mapper<DTO, ENTITY> {
    

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);
}
