package s28600_MP2.ZAtrybutem;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor {
    private static List<Doctor> extent = new ArrayList<>();
    private String name;
    private List<Appointment> appointments = new ArrayList<>();

    public Doctor(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Doctor> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Doctor name cannot be null or blank");
        this.name = name;
    }

    public List<Appointment> getAppointments() {
        return Collections.unmodifiableList(appointments);
    }

    public void addNewAppointment(LocalDate date, Patient patient) {
        if (date == null)
            throw new IllegalArgumentException("Date cannot be null");
        if (patient == null)
            throw new IllegalArgumentException("Patient cannot be null");
        for (Appointment appointment : appointments) {
            if (appointment.getDate().equals(date) && appointment.getPatient().equals(patient)) {
                throw new IllegalArgumentException("Appointment already exists");
            }
        }
        new Appointment(LocalDate.now(), patient, this);
    }

    public void addExistingAppointment(Appointment appointment) {
        if (appointment == null)
            throw new IllegalArgumentException("Appointment cannot be null");
        if (!appointments.contains(appointment))
            appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        if (appointment == null)
            throw new IllegalArgumentException("Appointment cannot be null");
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
        return "Doctor [name=" + name + "]";
    }
}
