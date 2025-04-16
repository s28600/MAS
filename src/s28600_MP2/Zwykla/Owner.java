package s28600_MP2.Zwykla;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Owner {
    private static List<Owner> owners = new ArrayList<>();
    private String name;
    private List<Car> carsOwned = new ArrayList<>();

    public Owner(String name) {
        setName(name);
        owners.add(this);
    }

    public static List<Owner> getOwners() {
        return Collections.unmodifiableList(owners);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        this.name = name;
    }

    public List<Car> getCarsOwned() {
        return Collections.unmodifiableList(carsOwned);
    }

    public void addCar(Car car) {
        if (!carsOwned.contains(car)){
            carsOwned.add(car);
            car.addOwner(this);
        }
    }

    public void removeCar(Car car) {
        if (carsOwned.remove(car))
            car.remove();
    }
}
