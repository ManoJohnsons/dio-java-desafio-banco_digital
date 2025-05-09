package edu.dio.bancodigital;

import java.util.Scanner;

import edu.dio.bancodigital.bankcontext.Bank;
import edu.dio.bancodigital.usercontext.User;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean hasOperationEnded = true;
        Bank bank = new Bank(sc);

        while (hasOperationEnded) {
            try {
                System.out.println("=== Sistema Bancário ===");
                System.out.println("Escolha uma opção: ");
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Mostrar informações das contas");
                System.out.println("3 - Gerenciar conta");
                System.out.println("4 - Obter lista de Usuários");
                System.out.println("5 - Encontrar usuário por nome");
                System.out.println("6 - Sair");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Digite o seu nome: ");
                        String name = sc.nextLine();
                        System.out.println("Digite a sua idade: ");
                        int age = sc.nextInt();
                        User user = new User(name, age);
                        bank.createAccount(user);
                        break;
                    case 2:
                        bank.showInfoAccounts();
                        break;
                    case 3:
                        System.out.println("Digite o seu nome: ");
                        String userName = sc.nextLine();
                        System.out.println("Digite a agencia da sua conta: ");
                        String agencyAccount = sc.nextLine();
                        System.out.println("Digite o Nº da sua conta: ");
                        String numberAccount = sc.nextLine();
                        bank.manageAccount(bank.getUserByName(userName), agencyAccount, numberAccount);
                        break;
                    case 4:
                        System.out.println(bank.getUsers());
                        break;
                    case 5:
                        System.out.println("Digite um nome: ");
                        String searchName = sc.nextLine();
                        System.out.println(bank.getUserByName(searchName));
                        break;
                    case 6:
                        hasOperationEnded = false;
                        break;
                    default:
                        throw new IllegalArgumentException("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
