package s28600_MP2.Zwykla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private static List<Car> extent = new ArrayList<>();
    private String name;
    private Owner ownedBy;

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
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        this.name = name;
    }

    public Owner getOwnedBy() {
        return ownedBy;
    }

    public void addOwner(Owner owner) {
        if (ownedBy == null){
            ownedBy = owner;
            owner.addCar(this);
        }
    }

    public void remove() {
        if (ownedBy != null){
            ownedBy.removeCar(this);
            ownedBy = null;
        }
    }


}
