package edu.dio.bancodigital.usercontext;

import java.util.ArrayList;
import java.util.List;

import edu.dio.bancodigital.accountcontext.Account;

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
        return accounts.stream()
                .filter(account -> account.getAgencyAccount().equals(agencyNumber)
                        && account.getNumberAccount().equals(accountNumber))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada."));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Informações do Usuário ===\n");
        sb.append("Nome: ").append(name).append("\n");
        sb.append("Idade: ").append(age).append(" anos\n");
        sb.append("Contas:\n");

        if (accounts.isEmpty()) {
            sb.append("  Nenhuma conta vinculada.\n");
        } else {
            accounts.forEach(account -> {
                sb.append("  - Agência: ").append(account.getAgencyAccount())
                        .append(", Conta: ").append(account.getNumberAccount())
                        .append("\n");
            });
        }

        sb.append("=============================\n");
        return sb.toString();
    }
}
