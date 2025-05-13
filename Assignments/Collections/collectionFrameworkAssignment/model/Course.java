package collectionFrameworkAssignment.model;

import collectionFrameworkAssignment.Student;

import java.util.*;

public class Course {
    private String courseId;
    private String courseName;
    private String instructorName;
    private int capacity;
    private int credits;
    private Set<Student> enrolledStudents;
    private Queue<Student> waitlist;

    // Constructor
    public Course(String courseId, String courseName, String instructorName, int capacity, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.capacity = capacity;
        this.credits = credits;
        this.enrolledStudents = new TreeSet<>(Comparator.comparing(Student::getName)); // Sorting by name
        this.waitlist = new LinkedList<>();
    }

    // Getters and Setters
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCredits() {
        return credits;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Queue<Student> getWaitlist() {
        return waitlist;
    }

    // Add student to enrolled list
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            return enrolledStudents.add(student); // Add student to enrolled list
        }
        return false; // If full, student is not added
    }

    // Add student to waitlist
    public boolean addToWaitlist(Student student) {
        return waitlist.offer(student); // Add to the end of waitlist
    }
}
