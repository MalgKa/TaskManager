package pl.coderslab;


import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {

        boolean workingLoop = true;
        ;
        while(workingLoop){
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
                    workingLoop = false;
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BACKGROUND + "It's possible that you've made a typo when writing");
            }
        }

// tablica dwuwymiarowa ale nie wiem po co ???!!!!!!!!
//        String[][] array2D = new String[tasksArray.length][];
//        for (int i = 0; i < tasksArray.length; i++) {
//            array2D[i] = tasksArray[i].split(", ");
//        }
//        System.out.println(array2D[0][1]);


    }
}