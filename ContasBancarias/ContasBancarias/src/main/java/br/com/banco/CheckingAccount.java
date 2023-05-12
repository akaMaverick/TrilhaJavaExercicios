package br.com.banco;

import br.com.banco.exceptions.HigherWithdrawValueException;
import br.com.banco.exceptions.NegativeDepositValueException;
import br.com.banco.exceptions.NegativeWithdrawValueException;

import java.util.ArrayList;
import java.util.List;

public class CheckingAccount extends Account {

    public CheckingAccount(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double value) throws NegativeDepositValueException {
        if (value <= 0) {
            throw new NegativeDepositValueException("Deposito não pode ser menor ou igual a zero.");
        }
        super.balance += value;
    }

    @Override
    public void withdraw(double value) throws NegativeWithdrawValueException, HigherWithdrawValueException {
        if (value < 0) {
            throw new NegativeWithdrawValueException("O valor da tentativa de saque é negativo.");
        } else if (value > this.balance) {
            throw new HigherWithdrawValueException("O valor da tentiva de saque excede o valor" +
                    " da conta atual.");
        }
        super.balance -= value;
    }


}
