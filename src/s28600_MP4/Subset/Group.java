package s28600_MP4.Subset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private static List<Group> extent = new ArrayList<>();
    private String code;
    private List<Student> students = new ArrayList<>();
    private List<Student> ITNStudents = new ArrayList<>();

    public Group(String code) {
        setCode(code);
        extent.add(this);
    }

    public static List<Group> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.code = code;
    }

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public List<Student> getITNStudents() {
        return Collections.unmodifiableList(ITNStudents);
    }

    public void addStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");
        if (!students.contains(student)){
            students.add(student);
            student.addGroup(this);
        }
    }

    public void addITNStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");
        if (!students.contains(student))
            throw new IllegalArgumentException("Student is not in this group");
        if (!ITNStudents.contains(student)){
            ITNStudents.add(student);
            student.addITNGroup(this);
        }
    }

    public void removeITNStudent(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");
        if (ITNStudents.contains(student)){
            ITNStudents.remove(student);
            student.removeITNGroup(this);
        }
    }

    public void removeStudent(Student student) {
        removeITNStudent(student);
        if (students.contains(student)){
            students.remove(student);
            student.removeGroup(this);
        }
    }

    public void remove() {
        while (!students.isEmpty())
            removeStudent(students.getFirst());
        extent.remove(this);
    }
}
