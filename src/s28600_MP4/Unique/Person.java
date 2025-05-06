package s28600_MP4.Unique;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static List<Person> extent = new ArrayList<>();
    String name;
    String passportNumber;

    public Person(String name, String passportNumber) {
        setName(name);
        setPassportNumber(passportNumber);
        extent.add(this);
        System.out.println("Person created {Name: "+ name + ", PassportNumber: " + passportNumber + "}");
    }

    public static List<Person> getExtent() {
        return extent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        if (extent.stream().anyMatch(p -> p.getPassportNumber().equals(passportNumber)))
            throw new IllegalArgumentException("Person with same passport number already exists");
        this.passportNumber = passportNumber;
    }
}
