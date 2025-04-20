package s28600_MP3.Overlapping;

import java.util.Collections;
import java.util.EnumSet;

public class Player {
    private String name;
    private EnumSet<PlayerClass> playerClasses;
    private double meleeDamageMultiplier;
    private double magicDamageMultiplier;
    private double rangedDamageMultiplier;
    private double summonDamageMultiplier;

    public Player(String name, EnumSet<PlayerClass> playerClasses) {
        if(playerClasses == null || playerClasses.isEmpty()) {
            throw new IllegalArgumentException("Player cannot be created without a class");
        }
        this.playerClasses = playerClasses;
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.name = name;
    }

    public EnumSet<PlayerClass> getPlayerClasses() {
        return EnumSet.copyOf(playerClasses);
    }

    public double getMeleeDamageMultiplier() {
        if (!playerClasses.contains(PlayerClass.Melee))
            throw new UnsupportedOperationException("Player doesn't belong to melee class");
        return meleeDamageMultiplier;
    }

    public void setMeleeDamageMultiplier(double meleeDamageMultiplier) {
        if (!playerClasses.contains(PlayerClass.Melee))
            throw new UnsupportedOperationException("Player doesn't belong to melee class");
        if (meleeDamageMultiplier <= 0)
            throw new IllegalArgumentException("Damage multiplier must be greater than 0");
        this.meleeDamageMultiplier = meleeDamageMultiplier;
    }

    public double getMagicDamageMultiplier() {
        if (!playerClasses.contains(PlayerClass.Mage))
            throw new UnsupportedOperationException("Player doesn't belong to mage class");
        return magicDamageMultiplier;
    }

    public void setMagicDamageMultiplier(double magicDamageMultiplier) {
        if (!playerClasses.contains(PlayerClass.Mage))
            throw new UnsupportedOperationException("Player doesn't belong to mage class");
        if (magicDamageMultiplier <= 0)
            throw new IllegalArgumentException("Damage multiplier must be greater than 0");
        this.magicDamageMultiplier = magicDamageMultiplier;
    }

    public double getRangedDamageMultiplier() {
        if (!playerClasses.contains(PlayerClass.Ranger))
            throw new UnsupportedOperationException("Player doesn't belong to ranger class");
        return rangedDamageMultiplier;
    }

    public void setRangedDamageMultiplier(double rangedDamageMultiplier) {
        if (!playerClasses.contains(PlayerClass.Ranger))
            throw new UnsupportedOperationException("Player doesn't belong to ranger class");
        if (rangedDamageMultiplier <= 0)
            throw new IllegalArgumentException("Damage multiplier must be greater than 0");
        this.rangedDamageMultiplier = rangedDamageMultiplier;
    }

    public double getSummonDamageMultiplier() {
        if (!playerClasses.contains(PlayerClass.Summoner))
            throw new UnsupportedOperationException("Player doesn't belong to summoner class");
        return summonDamageMultiplier;
    }

    public void setSummonDamageMultiplier(double summonDamageMultiplier) {
        if (!playerClasses.contains(PlayerClass.Summoner))
            throw new UnsupportedOperationException("Player doesn't belong to summoner class");
        if (summonDamageMultiplier <= 0)
            throw new IllegalArgumentException("Damage multiplier must be greater than 0");
        this.summonDamageMultiplier = summonDamageMultiplier;
    }
}
