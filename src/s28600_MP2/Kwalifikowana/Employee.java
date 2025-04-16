package s28600_MP2.Kwalifikowana;

import java.util.*;

public class Employee {
    private static List<Employee> extent = new ArrayList<>();
    private String name;
    private Map<String, Project> worksOn = new TreeMap<>();

    public Employee(String name) {
        if(extent.stream().anyMatch(e -> e.getName().equals(name)))
            throw new IllegalArgumentException("Employee already exists");
        setName(name);
        extent.add(this);
    }

    public static List<Employee> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be null or blank");
        }
        this.name = name;
    }

    public Map<String, Project> getWorksOn() {
        return Collections.unmodifiableMap(worksOn);
    }

    public void addProject(Project newProject) {
        if (!worksOn.containsKey(newProject.getCodename())) {
            worksOn.put(newProject.getCodename(), newProject);
            newProject.addEmployee(this);
        }
    }

    public void removeProject(Project project) {
        if (worksOn.containsKey(project.getCodename())) {
            worksOn.remove(project.getCodename());
            project.removeEmployee(this);
        }
    }
}
