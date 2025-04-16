package s28600_MP2.Kwalifikowana;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project {
    private static List<Project> extent = new ArrayList<>();
    private String codename;
    private List<Employee> workedOnBy = new ArrayList<>();

    public Project(String codename) {
        if (codename == null || codename.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be null or blank");
        }
        this.codename = codename;
        extent.add(this);
    }

    public static List<Project> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getCodename() {
        return codename;
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

    public void removeEmployee(Employee employee) {
        if (workedOnBy.contains(employee)) {
            workedOnBy.remove(employee);
            employee.removeProject(this);
        }
    }
}
