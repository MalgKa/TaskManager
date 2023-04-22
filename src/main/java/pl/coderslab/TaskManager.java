package pl.coderslab;

import com.sun.security.jgss.GSSUtil;
import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) throws FileNotFoundException {

///odczyt z pliku
        Scanner scanFile = new Scanner(new File("tasks.csv"));
        StringBuilder reading = new StringBuilder();
        while (scanFile.hasNextLine()) {
            reading.append(scanFile.nextLine()).append("\n");
        }
        String[] tasksArray = reading.toString().split("\n");
        int counter = 1;
        for (String item : tasksArray) {
            System.out.println(counter++ + ": " + item);
        }

//dodawanie zadania
        try (FileWriter fileWriter = new FileWriter("tasks.csv", true)) {

            Scanner scanAddTask = new Scanner(System.in);
            boolean isLoopWorking = true;
            ;
            while (isLoopWorking) {
                System.out.print("Please add task description: ");
                String taskName = scanAddTask.nextLine();
//
                fileWriter.append("\n").append(taskName).append(",");
                System.out.print("Please add task due to date: ");
                String dueToDate = scanAddTask.nextLine();
//
                fileWriter.append(dueToDate).append(",");
                System.out.print("Is your task important (true/false): ");
                String taskImportance = scanAddTask.nextLine();
//
                fileWriter.append(taskImportance);
                isLoopWorking = false;

            }
        } catch (IOException ex) {
            System.out.println("brak pliku");
        }
///usuwanie taskow
//





//////////////////
// tablica dwuwymiarowa ale nie wiem po co ???!!!!!!!!
//        String[][] array2D = new String[tasksArray.length][];
//        for (int i = 0; i < tasksArray.length; i++) {
//            array2D[i] = tasksArray[i].split(", ");
//        }
//        System.out.println(array2D[0][1]);


        /// menu

        String[] menu = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "PLease select an option: ");

        for (String item : menu) {
            System.out.println(ConsoleColors.RESET + item);
        }

    }
}