package s28600_MP2.ZAtrybutem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment {
    private static List<Appointment> extent = new ArrayList<>();
    private LocalDate date;
    private Patient patient;
    private Doctor doctor;

    public Appointment(LocalDate date, Patient patient, Doctor doctor) {
        for (Appointment a : extent) {
            if (a.getDate().equals(date) && a.getPatient().equals(patient) && a.getDoctor().equals(doctor)) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }

        setDate(date);
        setPatient(patient);
        setDoctor(doctor);

        patient.addExistingAppointment(this);
        doctor.addExistingAppointment(this);

        extent.add(this);
    }

    public static List<Appointment> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public LocalDate getDate() {
        return date;
    }

    private void setDate(LocalDate date) {
        if(date == null)
            throw new IllegalArgumentException("Date cannot be null");
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    private void setPatient(Patient patient) {
        if (patient == null)
            throw new IllegalArgumentException("Patient cannot be null");
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    private void setDoctor(Doctor doctor) {
        if (doctor == null)
            throw new IllegalArgumentException("Doctor cannot be null");
        this.doctor = doctor;
    }



    public void removeAppointment() {
        if (patient != null){
            patient.removeAppointment(this);
            patient = null;
        }
        if (doctor != null){
            doctor.removeAppointment(this);
            doctor = null;
        }
        extent.remove(this);
    }

    @Override
    public String toString() {
        return "Appointment [date=" + date + ", patient=" + patient + ", doctor=" + doctor + "]";
    }
}
