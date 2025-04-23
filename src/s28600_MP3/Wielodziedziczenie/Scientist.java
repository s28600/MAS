package s28600_MP3.Wielodziedziczenie;

public class Scientist extends Employee {
    private String expertiseField;

    public Scientist(String name, double salary, String expertiseField) {
        super(name, salary);
        setExpertiseField(expertiseField);
    }

    public String getExpertiseField() {
        return expertiseField;
    }

    public void setExpertiseField(String expertiseField) {
        if (expertiseField == null || expertiseField.isBlank())
            throw new IllegalArgumentException("Expertise field cannot be null or blank");
        this.expertiseField = expertiseField;
    }

    public void doResearch() {
        System.out.println("Doing research");
    }
}
