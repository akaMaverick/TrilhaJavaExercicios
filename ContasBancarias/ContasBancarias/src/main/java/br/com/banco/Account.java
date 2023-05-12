package br.com.banco;
import br.com.banco.exceptions.HigherWithdrawValueException;
import br.com.banco.exceptions.NegativeDepositValueException;
import br.com.banco.exceptions.NegativeWithdrawValueException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    @Getter@Setter
    protected int accountNumber;
    @Getter
    protected double balance;


    public Account(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double value) throws NegativeDepositValueException;

    public abstract void withdraw(double value) throws NegativeWithdrawValueException, HigherWithdrawValueException;

}