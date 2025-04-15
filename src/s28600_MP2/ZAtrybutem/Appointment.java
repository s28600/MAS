package s28600_MP2.ZAtrybutem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Appointment {
    private static List<Appointment> appointments = new ArrayList<Appointment>();
    private LocalDate date;
    private Patient patient;
    private Doctor doctor;

    public Appointment(LocalDate date, Patient patient, Doctor doctor) {
        setDate(date);
        setPatient(patient);
        setDoctor(doctor);

        patient.addAppointment(this);
        doctor.addAppointment(this);

        appointments.add(this);
    }

    public static List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
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
        patient.removeAppointment(this);
        doctor.removeAppointment(this);
        patient = null;
        doctor = null;
        appointments.remove(this);
    }
}
