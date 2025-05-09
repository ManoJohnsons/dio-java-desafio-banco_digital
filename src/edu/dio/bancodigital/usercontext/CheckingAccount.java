package edu.dio.bancodigital.usercontext;

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
    public void transfer(int value, String agencyAccountDestination, String numberAccountDestination) {
        super.checkTransfer(agencyAccountDestination, numberAccountDestination);
        Account destinationAccount = super.holder.chooseAccount(agencyAccountDestination, numberAccountDestination);
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
