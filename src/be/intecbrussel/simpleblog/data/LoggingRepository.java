package be.intecbrussel.simpleblog.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class LoggingRepository {
    public void log(String message) {
        File file = new File("resources/log/log.txt");

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(file.toPath(), StandardOpenOption.APPEND)) {

            Files.createDirectories(file.toPath().getParent());
            bufferedWriter.write(message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
