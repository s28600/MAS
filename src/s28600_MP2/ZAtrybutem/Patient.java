package s28600_MP2.ZAtrybutem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient {
    private String name;
    private List<Appointment> doctorsAdmittedBy = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Owner name cannot be null or blank");
        this.name = name;
    }

    public List<Appointment> getDoctorsAdmittedBy() {
        return Collections.unmodifiableList(doctorsAdmittedBy);
    }

    public void addDoctor(Doctor doctor) {
        if(doctorsAdmittedBy.stream().noneMatch(appointment -> appointment.getDoctor() == doctor))
            new Appointment(LocalDate.now(), this, doctor);
    }

    public void addAppointment(Appointment appointment) {
        doctorsAdmittedBy.add(appointment);
    }

    public void removeAppointment(Appointment appointment) {
        doctorsAdmittedBy.remove(appointment);
    }
}
