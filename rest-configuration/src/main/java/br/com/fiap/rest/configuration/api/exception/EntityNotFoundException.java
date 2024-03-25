package br.com.fiap.rest.configuration.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

@Getter
public class EntityNotFoundException extends HttpStatusCodeException {

    private final String errorCode = "ENTITY_NOT_FOUND";
    private final String errorMessage = "Entidade não encontrada.";

    public EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND);
    }

    public EntityNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }

}
