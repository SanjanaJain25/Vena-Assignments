package collection_Day3;

import java.util.*;
import java.util.stream.Collectors;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private double grade;
    private String branch;

    public Student(int id, String name, int age, double grade, String branch) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.branch = branch;
    }

    public String getBranch() {
        return branch;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age +
                ", Grade: " + grade + ", Branch: " + branch;
    }
}

public class Q1_StudentManagement {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        // Adding 15 students
        students.add(new Student(1, "Sanjana", 20, 8.5, "CSE"));
        students.add(new Student(2, "Ranu", 21, 7.2, "ECE"));
        students.add(new Student(3, "Kratika", 22, 9.1, "CSE"));
        students.add(new Student(4, "Pragya", 19, 6.8, "EEE"));
        students.add(new Student(5, "Kuldeep", 20, 7.5, "ECE"));
        students.add(new Student(6, "Pradhyum", 21, 8.3, "MECH"));
        students.add(new Student(7, "Aman", 22, 9.4, "CSE"));
        students.add(new Student(8, "Bhavik", 20, 6.7, "EEE"));
        students.add(new Student(9, "Aditi", 21, 7.9, "MECH"));
        students.add(new Student(10, "Diya", 22, 8.0, "CSE"));
        students.add(new Student(11, "Pratik", 20, 7.2, "ECE"));
        students.add(new Student(12, "Manish", 21, 9.0, "EEE"));
        students.add(new Student(13, "Piyush", 22, 8.7, "MECH"));
        students.add(new Student(14, "Shubham", 19, 9.5, "CSE"));
        students.add(new Student(15, "Siya", 20, 6.5, "ECE"));

        // Sorting students by branch, then by grade (descending)
        students.sort(Comparator.comparing(Student::getBranch)
                .thenComparing(Comparator.comparing(Student::getGrade).reversed()));

        System.out.println("=== Sorted Students ===");
        for (Student s : students) {
            System.out.println(s);
        }

        // Grouping students by branch
        Map<String, List<Student>> groupedByBranch = students.stream()
                .collect(Collectors.groupingBy(Student::getBranch));

        System.out.println("\n=== Students Grouped by Branch ===");
        for (Map.Entry<String, List<Student>> entry : groupedByBranch.entrySet()) {
            System.out.println("\nBranch: " + entry.getKey());
            for (Student s : entry.getValue()) {
                System.out.println(s);
            }
        }
    }
}
