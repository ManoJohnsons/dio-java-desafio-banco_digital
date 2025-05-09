package edu.dio.bancodigital.usercontext;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int age;
    private List<Account> accounts;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isMinor() {
        return age < 18;
    }

    public void linkAccount(Account account) {
        accounts.add(account);
    }

    public boolean hasAccount() {
        return !accounts.isEmpty();
    }

    public boolean hasAccountOfType(Class<? extends Account> accountType) {
        return accounts.stream().anyMatch(account -> account.getClass().equals(accountType));
    }

    public Account chooseAccount(String agencyNumber, String accountNumber) {
        return accounts.stream().filter(account -> account.getAgencyAccount().equals(agencyNumber) && account.getNumberAccount().equals(accountNumber)).findFirst().orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada."));
    }
}
