package s28600_MP3.Wielodziedziczenie;

public class DoctorScientist extends Scientist implements IDoctor {
    private Doctor doctor;

    private DoctorScientist(Doctor doctor, double salary, String expertiseField) {
        super(doctor.getName(), salary, expertiseField);
        this.doctor = doctor;
    }

    public static DoctorScientist createDoctorScientist(Doctor doctor, double salary, String expertiseField) {
        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");
        return new DoctorScientist(doctor, salary, expertiseField);
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
