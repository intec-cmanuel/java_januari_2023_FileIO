package be.intecbrussel.simpleblog.data;

import be.intecbrussel.simpleblog.model.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountRepository {
    private Path accountFilePath = Paths.get("resources/accounts.txt");

    public AccountRepository() throws IOException{
        if (!accountFilePath.toFile().exists()) {
            Files.createFile(accountFilePath);
        }
    }

    public void registerAccount(Account account) throws IOException {
        for (Account accountRead : readAllAccounts()) {
            if (accountRead.getUsername().equalsIgnoreCase(account.getUsername())) {
                throw new IOException("Username already exists!");
            }
        }

        FileWriter fileWriter = new FileWriter(accountFilePath.toFile(), true);
        fileWriter.write("\n" + account.getUsername() + "☼" + account.getPassword()); //ALT + NUMPAD 1039
        fileWriter.close();
    }

    public List<Account> readAllAccounts() throws IOException {
        FileReader fileReader = new FileReader(accountFilePath.toFile());
        List<Account> accounts = new ArrayList<>();

        StringBuilder accountFileToString = new StringBuilder();
        int letterASCIIValue;
        while ((letterASCIIValue = fileReader.read()) != -1) {
            accountFileToString.append((char) letterASCIIValue);
        }

        String[] accountsAsStringArray = accountFileToString.toString().split("\n");
        for (String accountAsString : accountsAsStringArray) {
            String[] accountSplit = accountAsString.split("☼");
            Account account = new Account(accountSplit[0], accountSplit[1]);
            accounts.add(account);
        }

        fileReader.close();
        return accounts;
    }
}
