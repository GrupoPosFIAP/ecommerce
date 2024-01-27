package br.com.fiap.rest.configuration.api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

@Getter
public class InvalidAuthenticationException extends HttpStatusCodeException {

    private final String errorCode = "INVALID_AUTHENTICATION";
    private final String errorMessage = "Dados de autenticação inválidos.";

    public InvalidAuthenticationException() {
        super(HttpStatus.UNAUTHORIZED);
    }

}
