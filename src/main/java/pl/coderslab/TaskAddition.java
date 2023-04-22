package pl.coderslab;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TaskAddition {

    public static void add() {
        try (FileWriter fileWriter = new FileWriter("tasks.csv", true)) {

            Scanner scanAddTask = new Scanner(System.in);
            boolean isLoopWorking = true;

            while (isLoopWorking) {
                System.out.print("Please add task description: ");
                String taskName = scanAddTask.nextLine();

                fileWriter.append("\n").append(taskName).append(",");
                System.out.print("Please add task due to date: ");
                String dueToDate = scanAddTask.nextLine();

                fileWriter.append(dueToDate).append(",");
                System.out.print("Is your task important (true/false): ");
                String taskImportance = scanAddTask.nextLine();
                fileWriter.append(taskImportance);

                isLoopWorking = false;

            }
        } catch (IOException ex) {
            System.out.println("there is no such file");
        }
    }
}
