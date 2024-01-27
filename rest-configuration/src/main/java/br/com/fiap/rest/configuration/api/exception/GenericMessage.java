package br.com.fiap.rest.configuration.api.exception;

public class GenericMessage {

    private String errorCode = "INTERNAL_SERVER_ERROR";
    private String errorMessage = "Ocorreu um erro inesperado.";

    public GenericMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public GenericMessage() {
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
