package s28600_MP3.Abstract;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public double timeToTravelInSeconds(double meters) {
        double speed = 10;
        return meters/speed;
    }
}
