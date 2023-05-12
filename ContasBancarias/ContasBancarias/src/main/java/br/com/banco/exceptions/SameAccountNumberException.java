package br.com.banco.exceptions;

public class SameAccountNumberException extends Exception {
    public SameAccountNumberException(String message) {
        super("O número de conta já está em uso.");
    }
}
