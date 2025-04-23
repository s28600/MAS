package s28600_MP3;

import s28600_MP3.Abstract.*;
import s28600_MP3.Overlapping.*;
import s28600_MP3.Wielodziedziczenie.*;

import java.util.EnumSet;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Cat");
        Dog dog = new Dog("Dog");
        System.out.println(cat.timeToTravelInSeconds(20));
        System.out.println(dog.timeToTravelInSeconds(20));
        System.out.println(cat.timeToTravelInSeconds(200));
        System.out.println(dog.timeToTravelInSeconds(200));
        System.out.println(cat.timeToTravelInSeconds(0));
        System.out.println(dog.timeToTravelInSeconds(0));

        System.out.println("\n========================================\n");

        Player player = new Player("Player1", EnumSet.of(PlayerClass.Mage, PlayerClass.Melee));
        System.out.println(player.getName());
        System.out.println(player.getPlayerClasses());
        player.getPlayerClasses().remove(PlayerClass.Mage);
        System.out.println(player.getPlayerClasses());
        player.setMagicDamageMultiplier(2);
        System.out.println(player.getMagicDamageMultiplier());
        player.setMeleeDamageMultiplier(2);
        System.out.println(player.getMeleeDamageMultiplier());

        System.out.println("\n========================================\n");

        DoctorScientist doctorScientist = new DoctorScientist("Doctor", 1234, 1234, 1234, "Physiology");
        doctorScientist.admitPatient();
        doctorScientist.analyzeTests();
        doctorScientist.doResearch();
        System.out.println(doctorScientist.getName());
        System.out.println(doctorScientist.getSalary());
        System.out.println("Doctor extent: " + Doctor.getExtent());
        System.out.println("Doctor scientist extent: " + DoctorScientist.getExtent());
        doctorScientist.remove();
        System.out.println("Doctor extent: " + Doctor.getExtent());
        System.out.println("Doctor scientist extent: " + DoctorScientist.getExtent());


    }
}
