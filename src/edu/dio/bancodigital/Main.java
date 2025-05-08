package edu.dio.bancodigital;

import edu.dio.bancodigital.bankcontext.Bank;
import edu.dio.bancodigital.usercontext.Account;
import edu.dio.bancodigital.usercontext.CheckingAccount;
import edu.dio.bancodigital.usercontext.SavingsAccount;
import edu.dio.bancodigital.usercontext.User;

public class Main {
    public static void main(String[] args) {
        User user_1 = new User("John", 22);
        Account user_1_ca = new CheckingAccount(user_1);
        Account user_1_sa = new SavingsAccount(user_1);
        Bank bank = new Bank();
        bank.addAccount(user_1_ca);
        bank.addAccount(user_1_sa);
        bank.showInfoAccounts();
    }
}
