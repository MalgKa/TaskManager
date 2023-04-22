package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
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
            int taskToRemove = idToRemove.nextInt() - 1;
            System.out.println(taskToRemove);

            try (FileWriter fileWriter = new FileWriter("tasks.csv", false)) {

                System.out.println(Arrays.toString(tasksArray));
                tasksArray = ArrayUtils.remove(tasksArray, taskToRemove);
                System.out.println(Arrays.toString(tasksArray));
                for (int i = 0; i < tasksArray.length; i++) {
                    fileWriter.append(tasksArray[i]).append("\n");
                }
                System.out.println(Arrays.toString(tasksArray));

            } catch (IOException ex) {
                System.out.println("there is no such file");
            }
        } catch(FileNotFoundException ex){
            System.out.println("there is no such file");
        }
    }
}
