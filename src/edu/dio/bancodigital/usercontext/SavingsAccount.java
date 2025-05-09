package edu.dio.bancodigital.usercontext;

import edu.dio.bancodigital.exceptions.DailyLimitExceededException;

public class SavingsAccount extends Account {
    private int dailyWithdrawLimit;
    private int dailyTransferLimit;

    public SavingsAccount(User holder) {
        super(holder);
        this.dailyWithdrawLimit = 5;
        this.dailyTransferLimit = 3;
    }

    @Override
    public void deposit(int value) {
        super.checkDeposit(value);
        super.balance += value;
    }

    @Override
    public void withdraw(int value) {
        super.checkWithdraw(value);

        if (dailyWithdrawLimit <= 0)
            throw new DailyLimitExceededException("O limite diário de saques foi excedido.");

        super.balance -= value;
        dailyWithdrawLimit--;
    }

    @Override
    public void transfer(int value, Account destinationAccount) {
        super.checkTransfer(destinationAccount);

        if (dailyTransferLimit <= 0) {
            throw new DailyLimitExceededException("O limite diário de transferências foi excedido.");
        }

        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    @Override
    public void showExtract() {
        System.out.println("=== Conta Poupança ===");
        super.showInfo();
        System.out.println(String.format("Limite diário de saque atual: %d", dailyWithdrawLimit));
        System.out.println(String.format("Limite diário de tranferências atual: %d", dailyTransferLimit));
        System.out.println("======================");
    }

}
