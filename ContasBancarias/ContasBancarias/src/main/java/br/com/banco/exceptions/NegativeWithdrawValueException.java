package br.com.banco.exceptions;

public class NegativeWithdrawValueException extends Exception {
    public NegativeWithdrawValueException(String message) {
        super(message);
    }
}
