package s28600_MP4.Ordered;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task {
    private static List<Task> extent = new ArrayList<>();
    private String name;
    private int priority;

    public Task(String name, int priority) {
        setName(name);
        setPriority(priority);
        extent.add(this);
        extent.sort(Comparator.comparing(Task::getPriority));
    }

    public static List<Task> getExtent() {
        return Collections.unmodifiableList(extent);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        if (priority <= 0)
            throw new IllegalArgumentException("Priority cannot be less than zero");
        this.priority = priority;
        extent.sort(Comparator.comparing(Task::getPriority));
    }

    @Override
    public String toString() {
        return "Task{name=" + name + ", priority=" + priority + "}";
    }
}
