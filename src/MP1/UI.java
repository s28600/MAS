package MP1;

import java.util.Scanner;

public class UI {
    static Scanner scanner = new Scanner(System.in);
    private static final String[] optionsMenu = {
            "\nPlease select option:",
            "Read from file",
            "Create new cat manually",
            "Display list of all cats",
            "Display list of cats filtered by race",
            "Get age of a cat by name",
            "Save to file",
            "Quit"};

    public static void start(){
        while (true) {
            int option = readOption();
            System.out.println();
            switch (option){
                case 1 -> System.out.println("Read from file");
                case 2 -> System.out.println("Create new cat manually");
                case 3 -> Cat.printCatsList(Cat.getCats());
                case 4 -> System.out.println("Display list of cats filtered by race");
                case 5 -> System.out.println("Get age of a cat by name");
                case 6 -> System.out.println("Save to file");
                case 7 -> {
                    scanner.close();
                    return;
                }
            }
        }
    }

    private static int readOption(){
        System.out.println(optionsMenu[0]);
        for (int i = 1; i < optionsMenu.length; i++) {
            System.out.println("(" + i + ") " + optionsMenu[i]);
        }
        while (true) {
            try {
                System.out.print("-> ");
                int option = Integer.parseInt(scanner.next());
                if (option >= 1 && option <= optionsMenu.length-1) {
                    return option;
                }
            } catch (NumberFormatException ignored) {}
        }
    }
}
