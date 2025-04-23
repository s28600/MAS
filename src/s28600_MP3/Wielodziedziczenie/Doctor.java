package s28600_MP3.Wielodziedziczenie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor extends Employee implements IDoctor{
    private static List<Doctor> extent = new ArrayList<>();
    private int licenseNumber;
    private DoctorScientist doctorScientist;

    public Doctor(String name, double salary, int licenseNumber) {
        super(name, salary);
        setLicenseNumber(licenseNumber);
        extent.add(this);
    }

    public static List<Doctor> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    @Override
    public int getLicenseNumber() {
        return licenseNumber;
    }

    @Override
    public void setLicenseNumber(int licenseNumber) {
        if (licenseNumber < 0)
            throw new IllegalArgumentException("License number cannot be negative");
        this.licenseNumber = licenseNumber;
    }

    public DoctorScientist getDoctorScientist() {
        return doctorScientist;
    }

    public void setDoctorScientist(DoctorScientist doctorScientist) {
        if (doctorScientist == null)
            throw new IllegalArgumentException("DoctorScientist cannot be null");
        this.doctorScientist = doctorScientist;
    }

    public void remove() {
        if(extent.remove(this)) {
            if (doctorScientist != null) {
                doctorScientist.remove();
                doctorScientist = null;
            }
        }
    }

    @Override
    public void admitPatient() {
        System.out.println("Admitting patient");
    }

    @Override
    public void analyzeTests() {
        System.out.println("Analyzing tests");
    }
}
