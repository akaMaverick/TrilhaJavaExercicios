package br.com.banco.exceptions;

public class NegativeDepositValueException extends Exception {
    public NegativeDepositValueException(String message) {
        super(message);
    }


}
