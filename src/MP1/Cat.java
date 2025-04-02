package MP1;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cat implements Serializable {

    private static List<Cat> cats = new ArrayList<>();
    private static int min_month_to_sterilize = 5;
    private String name;
    private String race;
    private List<String> vaccines_done;
    private LocalDate birthdate;

    //==========Constructors==========
    public Cat(String name, String race, List<String> vaccines_done, LocalDate birthdate) {
        setName(name);
        setRace(race);
        setVaccines_done(vaccines_done);
        setBirthdate(birthdate);
        cats.add(this);
    }

    public Cat(String name, List<String> vaccines_done, LocalDate birthdate) {
        this(name, null, vaccines_done, birthdate);
    }

    //==========Getters==========
    public static List<Cat> getCats() {
        return Collections.unmodifiableList(cats);
    }

    public static int getMin_month_to_sterilize() {
        return min_month_to_sterilize;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public List<String> getVaccines_done() {
        return Collections.unmodifiableList(vaccines_done);
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    //==========Setters==========
    public static void setMin_month_to_sterilize(int min_month_to_sterilize) {
        if (min_month_to_sterilize <= 0) {
            throw new IllegalArgumentException("Minimum month to sterilize cannot be zero or negative");
        }
        Cat.min_month_to_sterilize = min_month_to_sterilize;
    }

    public void setName(String name) {
        this.name = validateString(name);
    }

    public void setRace(String race) {
        if (race == null) return;
        if (race.isEmpty()){
            throw new IllegalArgumentException("Race cannot be empty");
        }
        this.race = race;
    }

    public void setVaccines_done(List<String> vaccines_done) {
        if (vaccines_done == null) {
            throw new IllegalArgumentException("Vaccines list cannot be null");
        } else if (vaccines_done.isEmpty()) {
            throw new IllegalArgumentException("Vaccines list cannot be empty");
        }

        for (String v : vaccines_done) {
            validateString(v);
        }

        this.vaccines_done = vaccines_done;
    }

    public void addVaccine(String vaccine) {
        vaccines_done.add(validateString(vaccine));
    }

    public void removeVaccine(String vaccine) {
        vaccines_done.remove(validateString(vaccine));
    }

    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null");
        } else if (birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be in future");
        }
        this.birthdate = birthdate;
    }

    //==========Methods==========
    public String getAge(){
        int months = (LocalDate.now().getYear()*12+LocalDate.now().getMonthValue()) - (birthdate.getYear()*12+birthdate.getMonthValue());
        if (months/12 > 0) return months/12 + " years, " + (months%12) + " months";
        return months + " months";
    }

    public static List<Cat> getByRace(String race){
        if (race == null) {
            throw new IllegalArgumentException("Race cannot be null");
        } else if (race.isEmpty()){
            throw new IllegalArgumentException("Race cannot be empty");
        }

        List<Cat> filtered = new ArrayList<>();
        for (Cat cat : cats) {
            if (cat.getRace() != null){
                if (cat.getRace().equals(race)) filtered.add(cat);
            }
        }
        return filtered;
    }

    public static void writeToFile(String filename){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Cat cat : Cat.getCats()) {
                out.writeObject(cat);
            }
            System.out.println("Objects serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile(String filename){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            cats = new ArrayList<>();
            while (true) {
                try {
                    Cat cat = (Cat) in.readObject();
                    cats.add(cat);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Objects deserialized from " + filename + ":");
            Cat.printCatsList(cats);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + (race == null ? "" : ", race: " + race) + ", vaccines done: " + vaccines_done.toString() + ", birthdate: " + birthdate.toString();
    }

    //==========Utility==========
    public static String validateString(String input) {
        if (input == null) {
            throw new IllegalArgumentException("String cannot be null");
        } else if (input.isEmpty()) {
            throw new IllegalArgumentException("String cannot be empty");
        }
        return input;
    }

    public static void printCatsList(List<Cat> cats) {
        for (Cat cat : cats) {
            System.out.println(cat.toString());
        }
        System.out.println();
    }
}