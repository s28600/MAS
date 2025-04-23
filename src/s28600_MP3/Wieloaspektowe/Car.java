package s28600_MP3.Wieloaspektowe;

public class Car extends Vehicle {
    private boolean hasRoof;

    public Car(String name, int numberOfWheels, FuelType fuelType, boolean hasRoof) {
        super(name, numberOfWheels, fuelType);
        setHasRoof(hasRoof);
    }

    public boolean isHasRoof() {
        return hasRoof;
    }

    public void setHasRoof(boolean hasRoof) {
        this.hasRoof = hasRoof;
    }

    public void rollWindowsDown() {
        System.out.println("Windows rolled down");
    }
}
