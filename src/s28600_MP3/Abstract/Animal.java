package s28600_MP3.Abstract;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public abstract double timeToTravelInSeconds(double meters);
}
