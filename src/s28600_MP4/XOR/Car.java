package s28600_MP4.XOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private static List<Car> extent = new ArrayList<>();
    private String name;
    private Rental inPossessionOf;
    private Person rentedBy;

    public Car(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Car> getExtent() {
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

    public Rental getInPossessionOf() {
        return inPossessionOf;
    }

    public void setInPossessionOf(Rental rental) {
        if (rental == null)
            throw new IllegalArgumentException("Rental cannot be null");
        if (rentedBy != null)
            throw new IllegalArgumentException("Car is rented at the moment");
        if (inPossessionOf == null){
            inPossessionOf = rental;
            rental.addPossessed(this);
        }
    }

    public void removeInPossessionOf() {
        if (inPossessionOf != null){
            inPossessionOf.removePossessed(this);
            inPossessionOf = null;
        }
    }

    public Person getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(Person person) {
        if (person == null)
            throw new IllegalArgumentException("Person cannot be null");
        if (inPossessionOf != null)
            throw new IllegalArgumentException("Car is in rental");
        if (rentedBy == null){
            rentedBy = person;
            person.setRents(this);
        }
    }

    public void removeRentedBy() {
        if (rentedBy != null){
            Person temp = rentedBy;
            rentedBy = null;
            temp.removeRents();
        }
    }

    public void remove(){
        removeRentedBy();
        removeInPossessionOf();
        extent.remove(this);
    }
}
