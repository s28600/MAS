package s28600_MP2.Kwalifikowana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private static List<Project> extent = new ArrayList<>();
    private String codename;
    private List<Employee> workedOnBy = new ArrayList<>();

    public Project(String codename) {
        if(extent.stream().anyMatch(e -> e.getCodename().equals(codename)))
            throw new IllegalArgumentException("Project already exists");
        setCodename(codename);
        extent.add(this);
    }

    public static List<Project> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        if (codename == null || codename.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be null or blank");
        }
    }

    public List<Employee> getWorkedOnBy() {
        return Collections.unmodifiableList(workedOnBy);
    }

    public void addEmployee(Employee newEmployee) {
        if (!workedOnBy.contains(newEmployee)) {
            workedOnBy.add(newEmployee);
            newEmployee.addProject(this);
        }
    }
}
