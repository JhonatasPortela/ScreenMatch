package br.app.portela.screenmatch.exceptions;

public class ErroAnoInvalido extends RuntimeException{
    String message;

    public ErroAnoInvalido(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
