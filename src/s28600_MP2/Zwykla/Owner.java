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

    public void setCarsOwned(List<Car> carsOwned) {
        if (carsOwned == null)
            throw new IllegalArgumentException("Owned cars list cannot be null");
        for (Car car : carsOwned) {
            if (car == null)
                throw new IllegalArgumentException("Car cannot be null");
        }
        this.carsOwned = carsOwned;
    }

    public void addCar(Car car) {
        if (!carsOwned.contains(car)){
            carsOwned.add(car);
        }
    }

    public void removeCar(Car car) {
        if (carsOwned.remove(car))
            car.remove();
    }
}
