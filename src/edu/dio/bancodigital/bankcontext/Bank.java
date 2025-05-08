package edu.dio.bancodigital.bankcontext;

import java.util.ArrayList;
import java.util.List;

import edu.dio.bancodigital.usercontext.Account;

public class Bank {
    private List<Account> accountsList = new ArrayList<>();

    public void addAccount(Account account) {
        accountsList.add(account);
    }

    public void showInfoAccounts() {
        for (Account a : accountsList) {
            a.showExtract();
        }
    }
}
