package s28600_MP3.Wielodziedziczenie;

public class Doctor extends Person implements IDoctor{
    private double salary;

    public Doctor(String name, double salary) {
        super(name);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0)
            throw new IllegalArgumentException("Salary cannot be negative");
        this.salary = salary;
    }

    @Override
    public void admitPatient() {
        System.out.println("Admitting patient");
    }
}
