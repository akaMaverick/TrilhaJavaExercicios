package br.com.banco.exceptions;

public class HigherWithdrawValueException extends Exception{
    public HigherWithdrawValueException(String message) {
        super(message);
    }
}
