package s28600_MP2.Zwykla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private static List<Car> cars = new ArrayList<>();
    private String name;
    private Owner owner;

    public Car(String name, Owner owner) {
        setName(name);
        setOwner(owner);
        owner.addCar(this);
        cars.add(this);
    }

    public static List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        if (owner == null)
            throw new IllegalArgumentException("Owner cannot be null");
        this.owner = owner;
    }

    public void remove() {
        owner = null;
        cars.remove(this);
    }
}
