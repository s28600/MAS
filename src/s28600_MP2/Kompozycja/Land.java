package s28600_MP2.Kompozycja;

import java.util.*;

public class Land {
    private static List<Land> extent = new ArrayList<>();
    private static Set<Country> allCountries = new HashSet<>();
    private List<Country> countries = new ArrayList<>();
    private String name;

    public Land(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public static List<Land> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public static Set<Country> getAllCountries() {
        return Collections.unmodifiableSet(allCountries);
    }

    public List<Country> getCountries() {
        return Collections.unmodifiableList(countries);
    }

    public String getName() {
        return name;
    }

    public void addCountry(Country country) {
        if (countries.contains(country))
            throw new IllegalArgumentException("Country already exists within this land");
        if (allCountries.contains(country))
            throw new IllegalArgumentException("Country already is a part of another land");

        countries.add(country);
        allCountries.add(country);
    }

    public void removeCountry(Country country) {
        if (countries.contains(country)){
            countries.remove(country);
            allCountries.remove(country);
            country.remove();
        }
    }

    public void remove() {
        while (!countries.isEmpty()) {
            removeCountry(countries.getFirst());
        }
        extent.remove(this);
    }
}
