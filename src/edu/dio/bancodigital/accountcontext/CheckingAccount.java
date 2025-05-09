package edu.dio.bancodigital.accountcontext;

import edu.dio.bancodigital.usercontext.User;

public class CheckingAccount extends Account {

    public CheckingAccount(User holder) {
        super(holder);
    }

    @Override
    public void deposit(int value) {
        super.checkDeposit(value);
        super.balance += value;
    }

    @Override
    public void withdraw(int value) {
        super.checkWithdraw(value);
        super.balance -= value;
    }

    @Override
    public void transfer(int value, Account destinationAccount) {
        super.checkTransfer(destinationAccount);
        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    @Override
    public void showExtract() {
        System.out.println("=== Conta Corrente ===");
        super.showInfo();
        System.out.println("======================");
    }

}
