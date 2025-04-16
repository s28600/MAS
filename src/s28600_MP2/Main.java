package s28600_MP2;

import s28600_MP2.Kwalifikowana.Employee;
import s28600_MP2.Kwalifikowana.Project;
import s28600_MP2.ZAtrybutem.*;
import s28600_MP2.Zwykla.Car;
import s28600_MP2.Zwykla.Owner;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Patient");
        Doctor doctor = new Doctor("Doctor");
        Appointment appointment = new Appointment(LocalDate.now(), patient, doctor);
        System.out.println(Appointment.getExtent());
        appointment.removeAppointment();
        System.out.println(Appointment.getExtent());
        System.out.println();

        Car car = new Car("Car");
        Owner owner = new Owner("Owner");
        owner.addCar(car);
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());
        owner.removeCar(car);
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());
        System.out.println("========================================");
        car.addOwner(owner);
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());
        car.remove();
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());

        System.out.println("\n========================================\n");

        Employee employee1 = new Employee("Employee");
        Project project = new Project("Project");
        employee1.addProject(project);
        System.out.println(employee1.getWorksOn().keySet());
        System.out.println(project.getWorkedOnBy());
    }
}
