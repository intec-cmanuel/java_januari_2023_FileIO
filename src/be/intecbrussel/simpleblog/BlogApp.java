package be.intecbrussel.simpleblog;

import be.intecbrussel.simpleblog.data.AccountRepository;
import be.intecbrussel.simpleblog.model.Account;
import be.intecbrussel.simpleblog.service.AccountService;
import be.intecbrussel.simpleblog.service.LoggingService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class BlogApp {
    private static LoggingService loggingService = new LoggingService();
    public static void main(String[] args) {
        appRunning : while (true){
            System.out.println("Hello, welcome to ManuelOSX");
            System.out.println("Do you want to register(1) or login(2) or exit(4)");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    displayAllAccounts();
                    break;
                case 4:
                    break appRunning;
            }
        }

        System.out.println("Thank you for shopping with us!");
    }

    private static void displayAllAccounts() {
        try {
            AccountService accountService = new AccountService();
            List<Account> accounts = accountService.readAllAccounts();
            accounts.forEach(System.out::println);
            throw new IOException("Everything works as expected");
        } catch (IOException e) {
            loggingService.error(e);
            System.err.println("Something went wrong displaying all accounts. Please dont contact me.");
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
            loggingService.warn(e);
            System.err.println("Something went wrong logging in. HELP");
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
            loggingService.debug(e);
            System.err.println("SEND HELP NOW!");
        }

    }
}



























