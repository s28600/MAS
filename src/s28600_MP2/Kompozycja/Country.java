package s28600_MP2.Kompozycja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Country {
    private static List<Country> extent = new ArrayList<>();
    private String name;
    private Land land;

    public Country(Land land, String name) {
        if (land == null)
            throw new NullPointerException("Land cannot be null");
        if (name == null || name.isBlank())
            throw new NullPointerException("Name cannot be null or blank");

        this.name = name;
        this.land = land;
        land.addCountry(this);
        extent.add(this);
    }

    public static List<Country> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public Land getLand() {
        return land;
    }

    public void remove() {
        if (land != null){
            land.removeCountry(this);
            land = null;
            extent.remove(this);
        }
    }

    @Override
    public String toString() {
        return "Country{name=" + name + ", land=" + land.getName() + "}";
    }
}
