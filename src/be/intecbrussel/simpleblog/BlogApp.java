package be.intecbrussel.simpleblog;

import be.intecbrussel.simpleblog.data.AccountRepository;
import be.intecbrussel.simpleblog.model.Account;
import be.intecbrussel.simpleblog.service.AccountService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BlogApp {
    public static void main(String[] args) {
        System.out.println("Hello, welcome to ManuelOSX");
        System.out.println("Do you want to register(1) or login(2)");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                register();
                break;
            case 2:
                login();
                break;
            case 3:
                displayAllAccounts();
                break;
        }

        System.out.println("Thank you for shopping with us!");
    }

    private static void displayAllAccounts() {
        try {
            AccountService accountService = new AccountService();
            List<Account> accounts = accountService.readAllAccounts();
            accounts.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your username?");
        String username = scanner.nextLine();
        System.out.println("What is your password?");
        String password = scanner.nextLine();

        try {
            AccountService accountService = new AccountService();
            Account account = accountService.login(username, password);
            System.out.println(account.getUsername() + " has succesfully logged in!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your username?");
        String username = scanner.nextLine();
        System.out.println("What is your password?");
        String password = scanner.nextLine();

        try {
            AccountService accountService = new AccountService();
            accountService.registerAccount(username, password);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
