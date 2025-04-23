package s28600_MP3.Wielodziedziczenie;

public class Doctor extends Person implements IDoctor{
    private double salary;
    private DoctorScientist doctorScientist;

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

    public DoctorScientist getDoctorScientist() {
        return doctorScientist;
    }

    public void setDoctorScientist(DoctorScientist doctorScientist) {
        if (doctorScientist == null)
            throw new IllegalArgumentException("DoctorScientist cannot be null");
        this.doctorScientist = doctorScientist;
    }

    @Override
    public void admitPatient() {
        System.out.println("Admitting patient");
    }

    @Override
    public void analyzeTests() {
        System.out.println("Analyzing tests");
    }

    @Override
    public double getIncome() {
        return getSalary();
    }
}
