package be.intecbrussel.simpleblog.service;

import be.intecbrussel.simpleblog.data.AccountRepository;
import be.intecbrussel.simpleblog.model.Account;

import java.io.IOException;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() throws IOException{
        this.accountRepository = new AccountRepository();
    }

    public void registerAccount(String username, String password) throws IOException {
        Account account = new Account(username, password);
        accountRepository.registerAccount(account);
    }
}

























