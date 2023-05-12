package br.com.banco.exceptions;

public class NegativeBalanceForInterestException extends Exception {
    public NegativeBalanceForInterestException(String message) {
        super(message);
    }
}
