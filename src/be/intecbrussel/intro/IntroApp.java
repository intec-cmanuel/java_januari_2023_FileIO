package be.intecbrussel.intro;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IntroApp {
    public static void main(String[] args) {

        /**
         * File
         * Files
         * Path
         * Paths
         */

        // File with Absolute Path
        File myResourceFolder = new File("C:\\Users\\ffxiv\\Documents\\Intec\\projects\\JavaJanuari2023\\FileIO\\resources");

        // File with Relative Path
        File myResourceFolderRelative = new File("resources");

        // Path with Absolute Path
        Path myResourceFolderPath = Paths.get("C:\\Users\\ffxiv\\Documents\\Intec\\projects\\JavaJanuari2023\\FileIO\\resources");

        // Path with Relative Path
        Path myResourceFolderPathRelative = Paths.get("FileIO.iml");

        System.out.println(myResourceFolder);
        System.out.println(myResourceFolderRelative);
        System.out.println(myResourceFolderPath);
        System.out.println(myResourceFolderPathRelative);

        System.out.println(Files.isDirectory(myResourceFolderPathRelative));
    }
}
