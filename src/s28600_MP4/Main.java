package s28600_MP4;

import s28600_MP4.Atrybut.CreditCard;
import s28600_MP4.Subset.*;
import s28600_MP4.Unique.Person;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("\n========================================\n");

        Person person1 = new Person("Person1", "PN12983712");
        try {
            Person person2 = new Person("Person2", "PN12983712");
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\n========================================\n");

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
    }
}
