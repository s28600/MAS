package s28600_MP3.Wielodziedziczenie;

public class DoctorScientist extends Scientist implements IDoctor {
    private Doctor doctor;

    public DoctorScientist(String name, double doctorSalary, int licenseNumber, double scientistSalary, String expertiseField) {
        super(name, scientistSalary, expertiseField);
        this.doctor = new Doctor(name, doctorSalary, licenseNumber);
        doctor.setDoctorScientist(this);
    }

    @Override
    public void admitPatient() {
        doctor.admitPatient();
    }

    @Override
    public void analyzeTests() {
        doctor.analyzeTests();
    }

    @Override
    public double getIncome() {
        return doctor.getIncome()+super.getIncome();
    }
}
