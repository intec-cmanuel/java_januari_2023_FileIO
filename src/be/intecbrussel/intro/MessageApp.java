package be.intecbrussel.intro;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

// for later: !@#$%^&*()_+-=][{}\|??/>.<,""§XæÖ} 8☼
public class MessageApp {
    // main throws Exception -> never!!!! this is for demonstration of Files only!!!
    public static void main(String[] args)  {
        //test();

        System.out.println("Welcome to ManuelOS. What is your username?");
        Path resources = Paths.get("resources");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();

        Path userFolder = resources.resolve(username);

//        if (!userFolder.toFile().exists()) {
//            Files.createDirectory(userFolder);
//        }


        try {
            Files.createDirectory(userFolder);
        } catch (FileAlreadyExistsException faee) {

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally block");
        }


        Path filePath = userFolder.resolve(username + ".txt");

//        if (!filePath.toFile().exists()) {
//            Files.createFile(filePath);
//        }

        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong! " + e.getMessage());

        }


        String text = "Welkom back test";

        try {
            Files.writeString(filePath, text, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Something went wrong! " + e.getMessage());

        }

        List<String> list = null;
        try {
            list = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong! " + e.getMessage());

        }

//        Files.writeString(filePath, text, StandardOpenOption.APPEND);
//        list = Files.readAllLines(filePath);


        list.forEach(string -> System.out.println("NewLine: " + string));


    }

    private static void test() throws IOException{
        Files.readAllLines(Paths.get(""));
    }

    private static void errorPlease() {
        errorPlease();
    }
}




























