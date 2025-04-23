package s28600_MP3.Wieloaspektowe;

public abstract class Vehicle {
    private String name;
    private int numberOfWheels;
    private FuelType fuelType;
    private double batteryCapacity;
    private double fuelTankCapacity;

    public Vehicle(String name, int numberOfWheels, FuelType fuelType) {
        setName(name);
        if (numberOfWheels < 1)
            throw new IllegalArgumentException("Number of wheels cannot be less than 1");
        this.numberOfWheels = numberOfWheels;
        if (fuelType == null)
            throw new IllegalArgumentException("Fuel type cannot be null");
        this.fuelType = fuelType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public double getBatteryCapacity() {
        if (fuelType != FuelType.electric)
            throw new UnsupportedOperationException("Fuel type is not electric");
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (fuelType != FuelType.electric)
            throw new UnsupportedOperationException("Fuel type is not electric");
        if (batteryCapacity <= 0)
            throw new IllegalArgumentException("Capacity has to be greater than 0");
        this.batteryCapacity = batteryCapacity;
    }

    public double getFuelTankCapacity() {
        if (fuelType != FuelType.gasoline)
            throw new UnsupportedOperationException("Fuel type is not gasoline");
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        if (fuelType != FuelType.electric)
            throw new UnsupportedOperationException("Fuel type is not gasoline");
        if (fuelTankCapacity <= 0)
            throw new IllegalArgumentException("Capacity has to be greater than 0");
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public void chargeBattery() {
        if (fuelType != FuelType.electric)
            throw new UnsupportedOperationException("Fuel type is not electric");
        System.out.println("Battery charged to " + batteryCapacity);
    }

    public void tankFuel() {
        if (fuelType != FuelType.gasoline)
            throw new UnsupportedOperationException("Fuel type is not gasoline");
        System.out.println("Tank filled to " + fuelTankCapacity);
    }
}
