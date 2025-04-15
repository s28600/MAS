package s28600_MP1;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UI {
    static Scanner scanner = new Scanner(System.in);
    private static final String[] optionsMenu = {
            "\nPlease select option:",
            "Read from file",
            "Populate cats list",
            "Display list of all cats",
            "Display list of cats filtered by race",
            "Display minimum age to get sterilized in months",
            "Get age of a cat by name",
            "Save to file",
            "Quit"};

    public static void start(){
        while (true) {
            int option = readOption();
            scanner.nextLine();
            System.out.println();
            switch (option){
                case 1 -> Cat.readFromFile("cats");
                case 2 -> {
                    populateCats();
                    System.out.println("Cats list populated");
                }
                case 3 -> {
                    if (Cat.getCats().isEmpty()) {
                        System.out.println("No cats found");
                    } else {
                        Cat.printCatsList(Cat.getCats());
                    }
                }
                case 4 -> {
                    try {
                        System.out.print("Enter race: ");
                        String race = Cat.validateString(scanner.nextLine());
                        if (Cat.getByRace(race).isEmpty()) {
                            System.out.println("No cats found");
                        } else {
                            Cat.printCatsList(Cat.getByRace(race));
                        }
                    } catch (IllegalArgumentException e){
                        System.out.println("Invalid race, please try again");
                    }
                }
                case 5 -> {
                    System.out.println("Minimal age for a cat to get sterilized is " + Cat.getMin_month_to_sterilize() + " months");
                }
                case 6 -> {
                    try {
                        System.out.print("Enter cat name: ");
                        String catName = Cat.validateString(scanner.nextLine());
                        for (Cat cat : Cat.getCats()){
                            if (cat.getName().equals(catName)) System.out.println(catName + "'s age is " + cat.getAge());
                        }
                    } catch (IllegalArgumentException e){
                        System.out.println("Invalid name, please try again");
                    }
                }
                case 7 -> Cat.writeToFile("cats");
                case 8 -> {
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

    private static void populateCats(){
        Cat cat1 = new Cat("Whiskers", "Siamese", List.of("Rabies", "FVRCP"), LocalDate.of(2020, 6, 15));
        Cat cat2 = new Cat("Mittens", List.of("Rabies"), LocalDate.of(2019, 8, 10));
        Cat cat3 = new Cat("Shadow", "Maine Coon", List.of("Rabies", "FVRCP", "Leukemia"), LocalDate.of(2021, 3, 5));
        Cat cat4 = new Cat("Bella", List.of("Rabies", "Leukemia"), LocalDate.of(2022, 1, 20));
        Cat cat5 = new Cat("Simba", "Sphynx", List.of("Rabies"), LocalDate.of(2020, 7, 18));
        Cat cat6 = new Cat("Luna", List.of("FVRCP", "Leukemia"), LocalDate.of(2021, 11, 12));
        Cat cat7 = new Cat("Oliver", "British Shorthair", List.of("Rabies", "FVRCP"), LocalDate.of(2018, 5, 30));
        Cat cat8 = new Cat("Chloe", List.of("Rabies", "Leukemia"), LocalDate.of(2019, 9, 25));
        Cat cat9 = new Cat("Tiger", "Scottish Fold", List.of("Rabies", "FVRCP"), LocalDate.of(2020, 8, 8));
        Cat cat10 = new Cat("Cleo", List.of("FVRCP"), LocalDate.of(2021, 6, 21));
        Cat cat11 = new Cat("Rocky", "Turkish Van", List.of("Rabies", "Leukemia"), LocalDate.of(2017, 12, 2));
        Cat cat12 = new Cat("Ginger", "Manx", List.of("Rabies"), LocalDate.of(2019, 4, 10));
        Cat cat13 = new Cat("Oscar", List.of("Rabies", "FVRCP"), LocalDate.of(2022, 2, 14));
        Cat cat14 = new Cat("Milo", "Burmese", List.of("Rabies", "FVRCP", "Leukemia"), LocalDate.of(2021, 10, 5));
        Cat cat15 = new Cat("Daisy", List.of("FVRCP"), LocalDate.of(2018, 3, 22));
        Cat cat16 = new Cat("Felix", "Cornish Rex", List.of("Rabies", "FVRCP"), LocalDate.of(2020, 9, 9));
        Cat cat17 = new Cat("Zoe", List.of("Rabies", "Leukemia"), LocalDate.of(2021, 7, 3));
        Cat cat18 = new Cat("Leo", "Devon Rex", List.of("Rabies", "FVRCP"), LocalDate.of(2019, 1, 18));
        Cat cat19 = new Cat("Lily", List.of("Rabies", "FVRCP", "Leukemia"), LocalDate.of(2022, 4, 6));
        Cat cat20 = new Cat("Charlie", "Japanese Bobtail", List.of("FVRCP"), LocalDate.of(2020, 5, 13));
    }
}
