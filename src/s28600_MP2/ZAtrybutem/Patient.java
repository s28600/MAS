package s28600_MP2.ZAtrybutem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient {
    private static List<Patient> extent = new ArrayList<>();
    private String name;
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Patient> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Patient name cannot be null or blank");
        this.name = name;
    }

    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }

    public void addNewAppointment(LocalDate date, Doctor doctor) {
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) && appointment.getDoctor().equals(doctor)) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }
        new Appointment(LocalDate.now(), this, doctor);
    }

    public void addExistingAppointment(Appointment appointment) {
        if (!appointments.contains(appointment))
            appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        if (appointments.contains(appointment)){
            appointments.remove(appointment);
            appointment.removeAppointment();
        }
    }

    public void removeFromExtent(){
        extent.remove(this);
    }

    @Override
    public String toString() {
        return "Patient [name=" + name + "]";
    }
}
