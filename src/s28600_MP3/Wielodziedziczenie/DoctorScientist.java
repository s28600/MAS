package s28600_MP3.Wielodziedziczenie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoctorScientist extends Scientist implements IDoctor {
    private static List<Scientist> extent = new ArrayList<>();
    private Doctor doctor;

    public DoctorScientist(String name, double doctorSalary, int licenseNumber, double scientistSalary, String expertiseField) {
        super(name, scientistSalary, expertiseField);
        this.doctor = new Doctor(name, doctorSalary, licenseNumber);
        doctor.setDoctorScientist(this);
        extent.add(this);
    }

    public static List<Scientist> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public void remove(){
        if (extent.remove(this)) {
            if (doctor != null) {
                doctor.remove();
                doctor = null;
            }
        }
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
    public int getLicenseNumber() {
        return doctor.getLicenseNumber();
    }

    @Override
    public void setLicenseNumber(int licenseNumber) {
        doctor.setLicenseNumber(licenseNumber);
    }

    @Override
    public double getSalary() {
        return doctor.getSalary()+super.getSalary();
    }

    public void setDoctorSalary(double salary) {
        doctor.setSalary(salary);
    }

    public void setScientistSalary(double salary) {
        super.setSalary(salary);
    }
}
