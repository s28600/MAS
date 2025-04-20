package s28600_MP3.Abstract;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public double timeToTravelInSeconds(double meters) {
        double speed = 15;
        int breaks = (int) (meters / 100);
        double breakTime = 3;
        return (meters/speed) + (breaks * breakTime);
    }
}
