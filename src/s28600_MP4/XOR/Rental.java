package s28600_MP4.XOR;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rental {
    private static List<Rental> extent = new ArrayList<>();
    private String name;
    private List<Car> possesses = new ArrayList<>();

    public Rental(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Rental> getExtent() {
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

    public List<Car> getPossesses() {
        return Collections.unmodifiableList(possesses);
    }

    public void addPossessed(Car car) {
        if (car == null)
            throw new IllegalArgumentException("Car cannot be null");
        if (car.getRentedBy() != null)
            throw new IllegalArgumentException("Car is already rented");
        if (!possesses.contains(car)){
            possesses.add(car);
            car.setInPossessionOf(this);
        }
    }

    public void removePossessed(Car car) {
        if (car == null)
            throw new IllegalArgumentException("Car cannot be null");
        if (possesses.contains(car)){
            possesses.remove(car);
            car.removeInPossessionOf();
        }
    }

    public void remove(){
        while (!possesses.isEmpty()) {
            possesses.getFirst().removeInPossessionOf();
            possesses.removeFirst();
        }
        extent.remove(this);
    }
}
