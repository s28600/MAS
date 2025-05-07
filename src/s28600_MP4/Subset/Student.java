package s28600_MP4.Subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    private static List<Student> extent = new ArrayList<>();
    private String name;
    private List<Group> partOf = new ArrayList<>();
    private List<Group> hasITNIn = new ArrayList<>();

    public Student(String name) {
        setName(name);
        extent.add(this);
    }

    public static List<Student> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public List<Group> getPartOf() {
        return Collections.unmodifiableList(partOf);
    }

    public List<Group> getHasITNIn() {
        return Collections.unmodifiableList(hasITNIn);
    }

    public void addGroup(Group group) {
        if (group == null)
            throw new IllegalArgumentException("Group cannot be null");
        if (!partOf.contains(group)) {
            partOf.add(group);
            group.addStudent(this);
        }
    }

    public void addITNGroup(Group group) {
        if (group == null)
            throw new IllegalArgumentException("Group cannot be null");
        if (!partOf.contains(group))
            throw new IllegalArgumentException("Student is not in this group");
        if (!hasITNIn.contains(group)){
            hasITNIn.add(group);
            group.addITNStudent(this);
        }
    }

    public void removeITNGroup(Group group) {
        if (group == null)
            throw new IllegalArgumentException("Group cannot be null");
        if (hasITNIn.contains(group)){
            hasITNIn.remove(group);
            group.removeITNStudent(this);
        }
    }

    public void removeGroup(Group group) {
        removeITNGroup(group);
        if (partOf.contains(group)){
            partOf.remove(group);
            group.removeStudent(this);
        }
    }

    public void remove() {
        while (!partOf.isEmpty())
            removeGroup(partOf.getFirst());
        extent.remove(this);
    }
}
