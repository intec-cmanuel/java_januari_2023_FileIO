package be.intecbrussel.simpleblog.service;

import be.intecbrussel.simpleblog.data.AccountRepository;
import be.intecbrussel.simpleblog.model.Account;

import java.io.IOException;
import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() throws IOException{
        this.accountRepository = new AccountRepository();
    }

    public void registerAccount(String username, String password) throws IOException {
        Account account = new Account(username, password);
        accountRepository.registerAccount(account);
    }

    public List<Account> readAllAccounts() throws IOException {
        return accountRepository.readAllAccounts();
    }

    public Account login(String username, String password) throws IOException {
        List<Account> accounts = readAllAccounts();
        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username) && account.getPassword().equalsIgnoreCase(password)) {
                return account;
            }
        }
        throw new IOException("Username and password combination is incorrect");
    }
}

























