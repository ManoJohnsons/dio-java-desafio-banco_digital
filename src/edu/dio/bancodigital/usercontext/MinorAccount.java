package edu.dio.bancodigital.usercontext;

import edu.dio.bancodigital.exceptions.DailyLimitExceededException;

public class MinorAccount extends Account {
    private int dailyWithdrawLimitValue;
    private int dailyTransferLimit;

    public MinorAccount(User holder) {
        super(holder);
        dailyWithdrawLimitValue = 25000;
        dailyTransferLimit = 3;
    }

    @Override
    public void deposit(int value) {
        super.checkDeposit(value);
        super.balance += value;
    }

    @Override
    public void withdraw(int value) {
        super.checkDeposit(value);

        if (dailyWithdrawLimitValue <= 0)
            throw new DailyLimitExceededException("O valor diário de saques foi excedido.");

        super.balance -= value;
        dailyWithdrawLimitValue -= value;
    }

    @Override
    public void transfer(int value, String agencyAccountDestination, String numberAccountDestination) {
        super.checkTransfer(agencyAccountDestination, numberAccountDestination);
        Account destinationAccount = super.holder.chooseAccount(agencyAccountDestination, numberAccountDestination);

        if (dailyTransferLimit <= 0) {
            throw new DailyLimitExceededException("O limite diário de transferências foi excedido.");
        }

        this.withdraw(value);
        destinationAccount.deposit(value);
        dailyTransferLimit--;
    }

    @Override
    public void showExtract() {
        System.out.println("=== Conta para menores ===");
        super.showInfo();
        System.out
                .println(String.format("Valor diário de saque atual: R$%.2f", (double) dailyWithdrawLimitValue / 100));
        System.out.println(String.format("Limite diário de tranferências atual: %d", dailyTransferLimit));
        System.out.println("==========================");
    }
}
