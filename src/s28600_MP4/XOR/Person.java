package s28600_MP4.XOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private static List<Person> extent = new ArrayList<>();
    private String name;
    private Car rents;

    public Person(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Person> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public Car getRents() {
        return rents;
    }

    public void setRents(Car car) {
        if (car == null)
            throw new IllegalArgumentException("Car cannot be null");
        if (car.getInPossessionOf() != null)
            throw new IllegalArgumentException("Car is possessed by rental");
        if (rents == null){
            rents = car;
            car.setRentedBy(this);
        }
    }

    public void removeRents() {
        if (rents != null){
            Car temp = rents;
            rents = null;
            temp.removeRentedBy();
        }
    }

    public void remove(){
        removeRents();
        extent.remove(this);
    }
}
