package s28600_MP3.Wielodziedziczenie;

public class Scientist extends Person {
    private double salary;
    private String expertiseField;

    public Scientist(String name, double salary, String expertiseField) {
        super(name);
        setSalary(salary);
        setExpertiseField(expertiseField);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0)
            throw new IllegalArgumentException("Salary cannot be negative");
        this.salary = salary;
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
