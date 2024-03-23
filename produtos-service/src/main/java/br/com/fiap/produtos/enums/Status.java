package br.com.fiap.produtos.enums;

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