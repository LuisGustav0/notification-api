package com.ead.enums;

public enum ErrorType {

    METHOD_ARG_NOT_VALID_ERROR("Argumento ou valor(es) inválido(s)."),
    UNEXPECTED_ERROR("Um erro inesperado ocorreu, por favor, verifique os logs."),
    NOTIFICATION_NOT_FOUND("Notificação não encontrado.");

    private String error;

    ErrorType(String error) {
        this.error = error;
    }

    public String getMessage() {
        return this.error;
    }
}
