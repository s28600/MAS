package s28600_MP2;

import s28600_MP2.Kompozycja.*;
import s28600_MP2.Kwalifikowana.*;
import s28600_MP2.ZAtrybutem.*;
import s28600_MP2.Zwykla.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Patient");
        Doctor doctor = new Doctor("Doctor");
        Appointment appointment = new Appointment(LocalDate.now(), patient, doctor);
        System.out.println(Appointment.getExtent());
        appointment.removeAppointment();
        System.out.println(Appointment.getExtent());

        System.out.println("\n========================================\n");

        Car car = new Car("Car");
        Owner owner = new Owner("Owner");
        owner.addCar(car);
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());
        owner.removeCar(car);
        System.out.println("Owner: carsOwned -> " + owner.getCarsOwned());
        System.out.println("Cars extent: " + Car.getExtent());
        System.out.println("----------------------------------------");
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
        employee1.removeProject(project);
        System.out.println(employee1.getWorksOn().keySet());
        System.out.println(project.getWorkedOnBy());

        System.out.println("\n========================================\n");

        Land land1 = new Land("Land");
        Country country1 = new Country(land1, "Country1");
        Country country2 = new Country(land1, "Country2");
        Country country3 = new Country(land1, "Country3");
        Country country4 = new Country(land1, "Country4");

        System.out.println("Land contains: " + land1.getCountries());
        System.out.println("Countries extent: " + Country.getExtent());
        System.out.println("All parts: " + Land.getAllCountries());
        System.out.println("----------------------------------------");
        country1.remove();
        land1.removeCountry(country2);
        System.out.println("Land contains: " + land1.getCountries());
        System.out.println("Countries extent: " + Country.getExtent());
        System.out.println("All parts: " + Land.getAllCountries());
        System.out.println("----------------------------------------");
        System.out.println(country1.getLand());
        System.out.println(country2.getLand());
        land1.remove();
        System.out.println("Land contains: " + land1.getCountries());
        System.out.println("Countries extent: " + Country.getExtent());
        System.out.println("Land extent: " + Land.getExtent());
        System.out.println("All parts: " + Land.getAllCountries());
    }
}
