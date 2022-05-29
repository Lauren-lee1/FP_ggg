package scannerTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class driver {
    static Scanner scanner;
    public static void main(String[] args) throws FileNotFoundException{
        String source = "scannerTest/";
        setSource(source + "kevin1.txt");

        printBackwards();
    }

    public static void setSource(String filename) throws FileNotFoundException {
        File file = new File(filename);
        scanner = new Scanner(file);
    }

    public static void printBackwards() {
        String line = "";
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            printBackwards();
        }
        System.out.println(line);
    }
}
