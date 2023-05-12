package br.com.banco;

import br.com.banco.exceptions.NegativeBalanceForInterestException;

public interface SavingsAccount {
    public void applyInterest() throws NegativeBalanceForInterestException;
}
