package s28600_MP3.Wieloaspektowe;

public class Motorcycle extends Vehicle {
    public Motorcycle(String name, int numberOfWheels, FuelType fuelType) {
        super(name, numberOfWheels, fuelType);
    }

    public void doWheelie(){
        System.out.println("Done wheelie");
    }
}
