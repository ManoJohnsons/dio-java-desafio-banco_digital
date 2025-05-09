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
        this.holder.linkAccount(this);
    }

    public abstract void deposit(int value);

    public abstract void withdraw(int value);

    public abstract void transfer(int value, Account destinationAccount);

    public abstract void showExtract();

    protected void showInfo() {
        System.out.println(String.format("Titular: %s", holder.getName()));
        System.out.println(String.format("Agencia: %s", agencyAccount));
        System.out.println(String.format("Nº da Conta: %s", numberAccount));
        System.out.println(String.format("Saldo: R$%.2f", (double) balance / 100));
    }

    protected void checkDeposit(int value) {
        if (value <= 0)
            throw new IllegalArgumentException("O valor do deposito deve ser maior que zero.");
    }

    protected void checkWithdraw(int value) {
        if (value > this.balance)
            throw new IllegalArgumentException("O valor do saque deve ser menor que o valor do saldo.");

        if (value == 0)
            throw new IllegalArgumentException("O valor do saque não pode ser 0.");

        if (value < 0)
            throw new IllegalArgumentException("O valor do saque não pode ser negativo.");
    }

    protected void checkTransfer(Account destinationAccount) {
        if (destinationAccount == null) {
            throw new NullPointerException("A conta especificada não existe.");
        }

        if (destinationAccount.equals(this)) {
            throw new IllegalArgumentException("A conta especifica não pode ser a mesma a transferir.");
        }
    }

    public String getAgencyAccount() {
        return agencyAccount;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public User getHolder() {
        return holder;
    }
}
