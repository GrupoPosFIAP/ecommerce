package br.com.fiap.carrinho.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

public enum Status {
    VAZIO("Vazio"),
    EM_ANDAMENTO("Em andamento"),
    FINALIZADO("Finalizado");

    @Getter
    private final String status;

    private Status(String status) {
        this.status = status;
    }
}