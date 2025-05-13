package collectionFrameworkAssignment;

import java.util.Objects;

public class Student {
    private String id;
    private String name;
    private String email;
    private String year;
    private String branch;

    // Constructor
    public Student(String id, String name, String email, String year, String branch) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.year = year;
        this.branch = branch;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getYear() {
        return year;
    }

    public String getBranch() {
        return branch;
    }

    // Override equals and hashCode for uniqueness
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id.equals(student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }
}
