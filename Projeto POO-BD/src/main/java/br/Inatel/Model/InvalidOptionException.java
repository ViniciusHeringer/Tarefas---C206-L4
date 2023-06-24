package br.Inatel.Model;

public class InvalidOptionException extends RuntimeException {
    public InvalidOptionException(String mensagem) {
        super(mensagem);
    }
}
