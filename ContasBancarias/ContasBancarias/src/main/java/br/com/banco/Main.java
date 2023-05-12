package br.com.banco;

import br.com.banco.exceptions.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger("Main");

    public static void main(String[] args) {
        List<Integer> dataNumberAccounts = new ArrayList<>();
        Random random = new Random();
        boolean left = false;
        Scanner scanner = new Scanner(System.in);
        int accountType;
        do {
            logger.info("Bem-vindo ao setor de criação de conta!");
            logger.info("Digite o número do tipo de conta a ser criada:\n1)Conta Corrente" +
                    "\n2)Conta Poupança" + "\n3)Sair");
            accountType = scanner.nextInt();

            switch (accountType) {
                case 1:
                    int numberToChoseCheckingAccount = random.nextInt(10);
                    for (Integer numberAccount : dataNumberAccounts) {
                        if (numberAccount.equals(numberToChoseCheckingAccount)) {
                            try {
                                throw new SameAccountNumberException("Mesmo número de conta.");
                            } catch (SameAccountNumberException e) {
                                logger.info(e.getMessage());
                                return;
                            }
                        }
                    }
                    dataNumberAccounts.add(numberToChoseCheckingAccount);
                    CheckingAccount checkingAccount = new CheckingAccount(numberToChoseCheckingAccount, 0);

                    logger.info("Conta criada com sucesso, seu número da conta é: {}", checkingAccount.getAccountNumber());
                    do {
                        logger.info("Gostaria de fazer outro procedimento?\n1) Deposito" +
                                "\n2) Saque\n3) Saldo\n4) Sair");
                        int procedure = scanner.nextInt();
                        if (procedure == 1) {
                            logger.info("Digite o valor do deposito a ser realizado: ");
                            try {
                                double value = scanner.nextDouble();
                                checkingAccount.deposit(value);
                            } catch (NegativeDepositValueException e) {
                                logger.error(e.getMessage());
                            }
                        } else if (procedure == 2) {
                            logger.info("Digite o valor do saque a ser realizado: ");
                            double value = scanner.nextDouble();
                            try {
                                checkingAccount.withdraw(value);
                            } catch (NegativeWithdrawValueException | HigherWithdrawValueException e) {
                                logger.error(e.getMessage());
                            }
                        } else if (procedure == 3) {
                            logger.info("Saldo da conta: {}", checkingAccount.getBalance());
                        } else if (procedure == 4) {
                            left = true;
                        } else {
                            logger.info("Número inválido!");
                        }
                    } while (!left);
                    break;
                case 2:
                    int numberToChoseSavingAccount = random.nextInt(10);
                    for (Integer dataNumberAccount : dataNumberAccounts) {
                        if (dataNumberAccount.equals(numberToChoseSavingAccount)) {
                            try {
                                throw new SameAccountNumberException("Mesmo número de conta.");
                            } catch (SameAccountNumberException e) {
                                logger.error(e.getMessage());
                                return;
                            }
                        }
                    }
                    dataNumberAccounts.add(numberToChoseSavingAccount);
                    SavingsAccountImpl savingsAccount = new SavingsAccountImpl(numberToChoseSavingAccount, 0);
                    logger.info("Conta criada com sucesso, seu número da conta é: {}", savingsAccount.getAccountNumber());
                    do {
                        logger.info("Gostaria de fazer outro procedimento?\n1) Deposito" +
                                "\n2) Saque\n3) Saldo\n4) Sair");
                        int procedure = scanner.nextInt();
                        if (procedure == 1) {
                            logger.info("Digite o valor do deposito a ser realizado: ");
                            try {
                                double value = scanner.nextDouble();
                                savingsAccount.deposit(value);
                            } catch (NegativeDepositValueException e) {
                                logger.error(e.getMessage());
                            }
                        } else if (procedure == 2) {
                            logger.info("Digite o valor do saque a ser realizado: ");
                            double value = scanner.nextDouble();
                            try {
                                savingsAccount.withdraw(value);
                            } catch (NegativeWithdrawValueException | HigherWithdrawValueException e) {

                                logger.error(e.getMessage());
                            }
                        } else if (procedure == 3) {
                            try {
                                savingsAccount.applyInterest();
                            } catch (NegativeBalanceForInterestException e) {
                                logger.error(e.getMessage());
                            }
                            logger.info("Saldo da conta: {}", savingsAccount.getBalance());
                        } else if (procedure == 4) {
                            left = true;
                        } else {
                            logger.info("Número inválido!");
                        }
                    } while (!left);
                    break;
                default:
                    logger.info("Número digitado inválido.");

            }
        } while (accountType != 3);
    }
}
