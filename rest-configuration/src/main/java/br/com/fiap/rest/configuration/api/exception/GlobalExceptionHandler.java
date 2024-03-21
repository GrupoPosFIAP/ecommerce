package br.com.fiap.rest.configuration.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<GenericMessage> handleGenericExceptions(Exception exception) {
        return ResponseEntity.internalServerError().body(new GenericMessage());
    }

    @ExceptionHandler(value = HttpStatusCodeException.class)
    public ResponseEntity<GenericMessage> handleHttpStatusCodeException(HttpStatusCodeException exception) {
        return ResponseEntity
                .status(exception.getStatusCode())
                .body(new GenericMessage(exception.getStatusCode().toString(), exception.getStatusText()));
    }

    @ExceptionHandler(value = InvalidAuthenticationException.class)
    public ResponseEntity<GenericMessage> handleInvalidAuthenticationException(InvalidAuthenticationException exception) {
        return ResponseEntity
                .status(exception.getStatusCode())
                .body(new GenericMessage(exception.getErrorCode(), exception.getErrorMessage()));
    }

    @ExceptionHandler(value = {AccessDeniedException.class, InternalAuthenticationServiceException.class})
    public ResponseEntity<GenericMessage> handleAccessDeniedException() {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new GenericMessage(HttpStatus.FORBIDDEN.name(), "Acesso negado."));
    }

}
