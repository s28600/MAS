package MP1;

import java.time.LocalDate;
import java.util.List;

class Cat {

    static int min_month_to_sterilize = 5;

    private String name;
    private String race;
    private List<String> vaccines_done;
    private LocalDate birthdate;

    public Cat(String name, List<String> vaccines_done, LocalDate birthdate) {
        this.name = name;
        this.vaccines_done = vaccines_done;
        this.birthdate = birthdate;
    }

    public Cat(String name, String race, List<String> vaccines_done, LocalDate birthdate) {
        this.name = name;
        this.race = race;
        this.vaccines_done = vaccines_done;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        if (race.isEmpty()){
            throw new IllegalArgumentException("Race cannot be empty");
        }
        this.race = race;
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
