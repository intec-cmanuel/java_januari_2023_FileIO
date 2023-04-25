package be.intecbrussel.simpleblog.data;

import be.intecbrussel.simpleblog.model.Account;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AccountRepository {
    private Path accountFilePath = Paths.get("resources/accounts.txt");

    public AccountRepository() throws IOException{
        if (!accountFilePath.toFile().exists()) {
            Files.createFile(accountFilePath);
        }
    }

    public void registerAccount(Account account) throws IOException {
        FileWriter fileWriter = new FileWriter(accountFilePath.toFile(), true);
        fileWriter.write(account.getUsername() + "☼" + account.getPassword()); //ALT + NUMPAD 1039
        fileWriter.close();
    }

    public void readAllAccounts() {

    }
}
