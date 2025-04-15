package s28600_MP2.ZAtrybutem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Doctor {
    private String name;
    private List<Appointment> patientsAdmitted = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        this.name = name;
    }

    public List<Appointment> getPatientsAdmitted() {
        return Collections.unmodifiableList(patientsAdmitted);
    }

    public void addPatient(Patient patient) {
        if(patientsAdmitted.stream().noneMatch(appointment -> appointment.getPatient() == patient))
            new Appointment(LocalDate.now(), patient, this);
    }

    public void addAppointment(Appointment appointment) {
        patientsAdmitted.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        patientsAdmitted.remove(appointment);
    }
}
