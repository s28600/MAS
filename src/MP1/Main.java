package MP1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Cat {
    static List<Cat> cats = new ArrayList<Cat>();
    static int min_month_to_sterilize = 5;

    private String name;
    private String race;
    private List<String> vaccines_done;
    private LocalDate birthdate;

    public Cat(String name, List<String> vaccines_done, LocalDate birthdate) {
        setName(name);
        setVaccines_done(vaccines_done);
        setBirthdate(birthdate);
        cats.add(this);
    }

    public Cat(String name, String race, List<String> vaccines_done, LocalDate birthdate) {
        this(name, vaccines_done, birthdate);
        setRace(race);
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
        return vaccines_done;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public static void setMin_month_to_sterilize(int min_month_to_sterilize) {
        if (min_month_to_sterilize <= 0) {
            throw new IllegalArgumentException("Minimum month to sterilize cannot be zero or negative");
        }
        Cat.min_month_to_sterilize = min_month_to_sterilize;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        } else if (name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public void setRace(String race) {
        if (race == null) {
            throw new IllegalArgumentException("Race cannot be null");
        } else if (race.isEmpty()){
            throw new IllegalArgumentException("Race cannot be empty");
        }
        this.race = race;
    }

    public void setVaccines_done(List<String> vaccines_done) {
        if (vaccines_done == null) {
            throw new IllegalArgumentException("Vaccines done cannot be null");
        } else if (vaccines_done.isEmpty()) {
            throw new IllegalArgumentException("Vaccines done cannot be empty");
        }
        this.vaccines_done = vaccines_done;
    }

    public void setBirthdate(LocalDate birthdate) {
        if (birthdate == null) {
            throw new IllegalArgumentException("Birthdate cannot be null");
        } else if (birthdate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birthdate cannot be in future");
        }
        this.birthdate = birthdate;
    }

    public String getAge(){
        int months = LocalDate.now().minusMonths(birthdate.getMonthValue()).getMonthValue();
        if (months/12 > 0) return months/12 + " years, " + (months%12) + "months";
        return months + " months";
    }

    public static String getByRace(String race){
        if (race == null) {
            throw new IllegalArgumentException("Race cannot be null");
        } else if (race.isEmpty()){
            throw new IllegalArgumentException("Race cannot be empty");
        }

        List<String> filtered = new ArrayList<>();
        for (Cat cat : cats) {
             if (cat.getRace().equals(race)) filtered.add(cat.toString());
        }

        return filtered.toString();
    }

    @Override
    public String toString() {
        return "Name: " + name + (race.isEmpty() ? "" : ", race: " + race) + ", vaccines done: " + vaccines_done.toString() + ", birthdate: " + birthdate.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        
    }
}
