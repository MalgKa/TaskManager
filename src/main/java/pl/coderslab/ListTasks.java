package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ListTasks {
    public static void list() {

        try (Scanner scanFile = new Scanner(new File("tasks.csv"));) {

            StringBuilder reading = new StringBuilder();
            while (scanFile.hasNextLine()) {
                reading.append(scanFile.nextLine()).append("\n");
            }
            String[] tasksArray = reading.toString().split("\n");
            int counter = 1;
            for (String item : tasksArray) {
                System.out.println(counter++ + " : " + item);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("there is no such file");
            ex.printStackTrace();
        }
    }
}
