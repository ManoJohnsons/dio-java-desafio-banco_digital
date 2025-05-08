package edu.dio.bancodigital.usercontext;

public abstract class Account {
    private static final String AGENCY = "0001";
    private static int sequential = 1;

    protected String agencyAccount;
    protected String numberAccount;
    protected int balance;
    protected User holder;

    public Account(User holder) {
        this.agencyAccount = Account.AGENCY;
        this.numberAccount = Integer.toString(Account.sequential++);
        this.holder = holder;
    }

    public abstract void deposit(int value);

    public abstract void withdraw(int value);

    public abstract void transfer(int value, Account destinationAccount);

    public abstract void showExtract();

    protected void showInfo() {
        System.out.println(String.format("Titular: %s", holder.getName()));
        System.out.println(String.format("Agencia: %s", agencyAccount));
        System.out.println(String.format("Nº da Conta: %s", numberAccount));
        System.out.println(String.format("Saldo: %.2f", (double) balance));
    }
}
