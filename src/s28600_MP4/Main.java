package s28600_MP4;

import s28600_MP4.Atrybut.CreditCard;
import s28600_MP4.Bag.*;
import s28600_MP4.Ordered.Task;
import s28600_MP4.Own.CarReservation;
import s28600_MP4.Subset.*;
import s28600_MP4.Unique.Person;
import s28600_MP4.XOR.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n====================Attribute====================\n");

        CreditCard cc = new CreditCard(100);
        try {
            cc.setDebt(10);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        try {
            cc.setDebt(100000);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        cc.setDebt(1000);
        System.out.println(cc.getDebt());

        System.out.println("\n====================Unique====================\n");

        Person person1 = new Person("Person1", "PN12983712");
        try {
            Person person2 = new Person("Person2", "PN12983712");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n====================Subset====================\n");

        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");
        Group group = new Group("Group1");
        System.out.println("---------------Adding students into group---------------");
        student1.addGroup(group);
        group.addStudent(student2);
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());
        System.out.println("---------------Making students ITN students---------------");
        student1.addITNGroup(group);
        group.addITNStudent(student2);
        try {
            student3.addITNGroup(group);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());
        System.out.println("---------------Removing ITN students status---------------");
        student1.removeITNGroup(group);
        group.removeITNStudent(student2);
        student3.removeITNGroup(group);
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());
        System.out.println("---------------Removing students from group---------------");
        student1.removeGroup(group);
        group.removeStudent(student2);
        student3.removeGroup(group);
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());
        System.out.println("---------------Removing students from group while they have ITN---------------");
        student1.addGroup(group);
        group.addStudent(student2);
        student1.addITNGroup(group);
        group.addITNStudent(student2);
        System.out.println("Before:");
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());
        student1.removeGroup(group);
        group.removeStudent(student2);
        System.out.println("After:");
        System.out.println("Student 1 groups: " + student1.getPartOf());
        System.out.println("Student 2 groups: " + student2.getPartOf());
        System.out.println("Student 3 groups: " + student3.getPartOf());
        System.out.println("Students in group: " + group.getStudents());
        System.out.println("Student 1 ITN groups: " + student1.getHasITNIn());
        System.out.println("Student 2 ITN groups: " + student2.getHasITNIn());
        System.out.println("Student 3 ITN groups: " + student3.getHasITNIn());
        System.out.println("ITN students in group: " + group.getITNStudents());

        System.out.println("\n====================Bag====================\n");

        System.out.println("---------------Adding orders---------------");
        Client client = new Client("Client");
        Product product = new Product("Product");
        client.addNewOrder(product, 1);
        product.addNewOrder(client, 1);
        Order order1 = new Order(client, product, 1);
        Order order2 = new Order(client, product, 1);
        Order order3 = new Order(client, product, 1);
        System.out.println(client.getOrders());
        System.out.println(product.getOrders());
        System.out.println(Order.getExtent());
        System.out.println("---------------Removing orders---------------");
        client.removeOrder(order1);
        product.removeOrder(order2);
        order3.remove();
        System.out.println(client.getOrders());
        System.out.println(product.getOrders());
        System.out.println(Order.getExtent());
        System.out.println("---------------Removing client/product---------------");
        //client.remove();
        product.remove();
        System.out.println(client.getOrders());
        System.out.println(product.getOrders());
        System.out.println(Order.getExtent());

        System.out.println("\n====================Own====================\n");

        LocalDate before = LocalDate.of(2025, 5, 6);
        LocalDate after = LocalDate.now();
        try {
            CarReservation carReservation = new CarReservation(18, after, before);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        CarReservation carReservation = new CarReservation(18, before, after);

        System.out.println("\n====================Ordered====================\n");

        Task task1 = new Task("Task1", 1);
        Task task2 = new Task("Task2", 2);
        Task task3 = new Task("Task3", 2);
        Task task4 = new Task("Task4", 1);
        Task task5 = new Task("Task5", 3);
        for (Task t : Task.getExtent())
            System.out.println(t);
        System.out.println();
        task1.setPriority(4);
        for (Task t : Task.getExtent())
            System.out.println(t);
        System.out.println();

        System.out.println("\n====================XOR====================\n");
        Car car = new Car("Car");
        Rental rental = new Rental("Rental");
        s28600_MP4.XOR.Person person = new s28600_MP4.XOR.Person("Person");
        car.setRentedBy(person);
        System.out.println(car.getRentedBy());
        System.out.println(person.getRents());
        try {
            car.setInPossessionOf(rental);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        car.removeRentedBy();
        System.out.println(car.getRentedBy());
        System.out.println(person.getRents());
        car.setInPossessionOf(rental);
        System.out.println(car.getInPossessionOf());
        System.out.println(rental.getPossesses());
        car.removeInPossessionOf();
        System.out.println(car.getInPossessionOf());
        System.out.println(rental.getPossesses());
    }
}
