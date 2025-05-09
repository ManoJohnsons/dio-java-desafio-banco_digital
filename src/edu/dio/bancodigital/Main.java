package edu.dio.bancodigital;

import edu.dio.bancodigital.bankcontext.Bank;
import edu.dio.bancodigital.usercontext.User;

public class Main {
    public static void main(String[] args) {
        User user_1 = new User("John", 15);
        User user_2 = new User("Karine", 22);
        Bank bank = new Bank();
        bank.createAccount(user_1);
        bank.createAccount(user_2);
        bank.manageAccount(user_1, "0001", "1");
        bank.showInfoAccounts();
    }
}
