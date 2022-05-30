package promptTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class driver {
    static Scanner scanner;
    public static void main(String[] args) {
        StoryNode kevin1 = new StoryNode("kevin1.txt");
        String source = "promptTest/";
        setSource(source + kevin1.getValue());
        play();
    }

    public static void setSource(String filename){
        File file = new File(filename);
        
        try {
            scanner = new Scanner(file);
        } 
        catch (FileNotFoundException e) {}
    }

    public static void play() {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            if (line.equals("prompt()")) {
                prompt();
            } else {
                System.out.println(line);
                try {
                    Thread.sleep(250);
                } 
                catch (InterruptedException e) {}
            }
        }
    }

    public static void prompt() {
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        Scanner reader = new Scanner(System.in);
        String response = reader.nextLine();
        scanner.nextLine();

        if (response.equals("1")) {
            System.out.println(scanner.nextLine());
            scanner.nextLine();
        } else {
            scanner.nextLine();
            System.out.println(scanner.nextLine());
        }
    }

}
