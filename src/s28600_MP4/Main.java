package s28600_MP4;

import s28600_MP4.Atrybut.CreditCard;
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
    }
}
