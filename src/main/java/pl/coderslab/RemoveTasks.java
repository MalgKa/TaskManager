package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RemoveTasks {
    public static void remove() {
        try (Scanner scanFile = new Scanner(new File("tasks.csv"))) {

            StringBuilder reading = new StringBuilder();
            while (scanFile.hasNextLine()) {
                reading.append(scanFile.nextLine()).append("\n");
            }
            String[] tasksArray = reading.toString().split("\n");

            Scanner idToRemove = new Scanner(System.in);
            System.out.println("Please select number to remove: ");
            String taskToRemove = idToRemove.nextLine();

            if (NumberUtils.isParsable(taskToRemove) && Integer.parseInt(taskToRemove) - 1 >= 0 && Integer.parseInt(taskToRemove) - 1 < tasksArray.length) {
//
                try (FileWriter fileWriter = new FileWriter("tasks.csv", false)) {

                    tasksArray = ArrayUtils.remove(tasksArray, Integer.parseInt(taskToRemove) - 1);

                    for (String task : tasksArray) {
                        fileWriter.append(task).append("\n");
                    }

                } catch (IOException ex) {
                    System.out.println("there is no such file");
                }
            } else if (!NumberUtils.isParsable(taskToRemove)) {
                System.out.println(ConsoleColors.RED + "enter a number");
            } else if(Integer.parseInt(taskToRemove) - 1 < 0 || Integer.parseInt(taskToRemove) - 1 >= tasksArray.length){
                System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "enter a number in the range of 1 to " + tasksArray.length );
            }

        } catch (FileNotFoundException ex) {
            System.out.println("there is no such file");
        }
    }
}
