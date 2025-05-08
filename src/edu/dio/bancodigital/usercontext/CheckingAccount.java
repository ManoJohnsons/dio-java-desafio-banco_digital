package edu.dio.bancodigital.usercontext;

public class CheckingAccount extends Account {

    public CheckingAccount(User holder) {
        super(holder);
    }

    @Override
    public void deposit(int value) {
        super.balance += value;
    }

    @Override
    public void withdraw(int value) {
        super.balance -= value;
    }

    @Override
    public void transfer(int value, Account destinationAccount) {
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
