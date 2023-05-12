package br.com.banco;

import br.com.banco.exceptions.HigherWithdrawValueException;
import br.com.banco.exceptions.NegativeBalanceForInterestException;
import br.com.banco.exceptions.NegativeDepositValueException;
import br.com.banco.exceptions.NegativeWithdrawValueException;

public class SavingsAccountImpl extends Account implements SavingsAccount {

    public SavingsAccountImpl(int accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void applyInterest() throws NegativeBalanceForInterestException {
        if(this.balance <= 0) {
            throw new NegativeBalanceForInterestException("Para aplicação de juros é necessário " +
                    "ter um saldo maior que zero.");
        }
        double calculation = 1.0 / 100 * this.balance;
        super.balance += calculation;
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

    @Override
    public double getBalance() {
        return super.balance;
    }

    public int getAccountNumber() {
        return super.accountNumber;
    }
}
