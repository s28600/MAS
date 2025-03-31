package MP1;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
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

        Cat.printCatsList(Cat.getCats());
    }
}
