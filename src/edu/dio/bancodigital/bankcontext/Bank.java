package edu.dio.bancodigital.bankcontext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.dio.bancodigital.usercontext.Account;
import edu.dio.bancodigital.usercontext.AccountFactory;
import edu.dio.bancodigital.usercontext.CheckingAccountFactory;
import edu.dio.bancodigital.usercontext.MinorAccountFactory;
import edu.dio.bancodigital.usercontext.SavingAccountFactory;
import edu.dio.bancodigital.usercontext.User;

public class Bank {
    private List<Account> accountsList;
    private Scanner sc;

    public Bank(Scanner sc) {
        this.accountsList = new ArrayList<>();
        this.sc = sc;
    }

    public void createAccount(User user) {
        if (user.isMinor()) {
            AccountFactory minorFactory = new MinorAccountFactory();
            Account minorAccount = minorFactory.createAccount(user);
            accountsList.add(minorAccount);
            return;
        }
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                AccountFactory checkingFactory = new CheckingAccountFactory();
                Account checkingAccount = checkingFactory.createAccount(user);
                accountsList.add(checkingAccount);
                break;
            case 2:
                AccountFactory savingFactory = new SavingAccountFactory();
                Account savingAccount = savingFactory.createAccount(user);
                accountsList.add(savingAccount);
                break;
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }

    public void showInfoAccounts() {
        for (Account a : accountsList) {
            a.showExtract();
        }
    }

    public void manageAccount(User user, String agencyAccount, String numberAccount) {
        Account account = user.chooseAccount(agencyAccount, numberAccount);
        boolean hasOperationEnded = true;
        while (hasOperationEnded) {
            System.out.println("Escolha a ação que irá realizar:");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Transferência");
            System.out.println("4 - Mostrar dados da conta");
            System.out.println("5 - Sair");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Digite o valor a ser depositado: ");
                    int depositValue = sc.nextInt();
                    account.deposit(depositValue);
                    break;
                case 2:
                    System.out.println("Digite o valor a ser sacado: ");
                    int withdrawValue = sc.nextInt();
                    account.withdraw(withdrawValue);
                    break;
                case 3:
                    System.out.println("Digite o número da agencia do destinatario: ");
                    String agencyAccountDestination = sc.nextLine();
                    System.out.println("Digite o número da conta do destinatario: ");
                    String numberAccountDestination = sc.nextLine();
                    System.out.println("Digite o valor a ser transferido: ");
                    int transferValue = sc.nextInt();
                    Account destinationAccount = findAccout(agencyAccountDestination, numberAccountDestination);
                    account.transfer(transferValue, destinationAccount);
                    break;
                case 4:
                    account.showExtract();
                    break;
                case 5:
                    hasOperationEnded = false;
                    break;
                default:
                    throw new IllegalArgumentException("Opção inválida");
            }
        }
    }

    public List<User> getUsers() {
        List<User> usersList = new ArrayList<>();
        if (!accountsList.isEmpty()) {
            for (Account a : accountsList) {
                usersList.add(a.getHolder());
            }
        }
        return usersList;
    }

    public User getUserByName(String name) {
        User user = null;
        if (!getUsers().isEmpty()) {
            for (User u : getUsers()) {
                if (u.getName().equalsIgnoreCase(name)) {
                    user = u;
                }
            }
        }

        if (user == null)
            throw new NullPointerException("Usuário não encontrado.");
        return user;
    }

    private Account findAccout(String agencyAccount, String numberAccount) {
        Account account = null;
        if (!accountsList.isEmpty()) {
            for (Account a : accountsList) {
                if (a.getAgencyAccount().equals(agencyAccount) && a.getNumberAccount().equals(numberAccount)) {
                    account = a;
                }
            }
        }
        return account;
    }
}
