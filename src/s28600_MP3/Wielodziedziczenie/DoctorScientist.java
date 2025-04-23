package s28600_MP3.Wielodziedziczenie;

public class DoctorScientist extends Scientist implements IDoctor {
    public DoctorScientist(String name, double salary, String expertiseField) {
        super(name, salary, expertiseField);
    }

    public void admitPatient() {
        System.out.println("Admitting patient");
    }
}
