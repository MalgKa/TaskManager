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
    public static void main(String[] args) {

        String[] menu = {"add", "remove", "list", "exit"};
        System.out.println(ConsoleColors.BLUE + "Please select an option: ");

        for (String item : menu) {
            System.out.println(ConsoleColors.RESET + item);
        }

        Scanner menuScan = new Scanner(System.in);
        String menuChoice = menuScan.nextLine().toLowerCase();
        System.out.println(menuChoice);

        switch(menuChoice){
            case "list":
                ListTasks.list();
                break;
            case "add":
                TaskAddition.add();
                break;
            case "remove":
                RemoveTasks.remove();
                break;
            case "exit":
                System.out.println(ConsoleColors.PURPLE_BOLD + "bye, bye");
                break;
            default:
                System.out.println(ConsoleColors.RED_BACKGROUND + "It's possible that you've made a typo when writing");
        }


///odczyt z pliku


//dodawanie zadania


///usuwanie taskow


//////////////////
// tablica dwuwymiarowa ale nie wiem po co ???!!!!!!!!
//        String[][] array2D = new String[tasksArray.length][];
//        for (int i = 0; i < tasksArray.length; i++) {
//            array2D[i] = tasksArray[i].split(", ");
//        }
//        System.out.println(array2D[0][1]);


        // menu


    }
}