package collectionFrameworkAssignment.service;


import collectionFrameworkAssignment.Student;
import collectionFrameworkAssignment.model.Course;

import java.util.*;

public class RegistrationSystem {
    private Map<String, Course> courses;
    private Map<String, Student> students;

    public RegistrationSystem() {
        courses = new HashMap<>();
        students = new HashMap<>();
    }

    // Register student to course
    public boolean registerStudentToCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course ID.");
            return false;
        }

        // Check if student is already enrolled or waitlisted
        if (course.getEnrolledStudents().contains(student)) {
            System.out.println("Student is already enrolled.");
            return false;
        } else if (course.getWaitlist().contains(student)) {
            System.out.println("Student is already waitlisted.");
            return false;
        }

        // If course is full, add to waitlist
        if (!course.enrollStudent(student)) {
            course.addToWaitlist(student);
            System.out.println("Course full, student added to waitlist.");
            return false;
        }

        System.out.println("Student successfully registered for the course.");
        return true;
    }

    // Drop course and promote waitlist
    public boolean dropCourse(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = courses.get(courseId);

        if (student == null || course == null) {
            System.out.println("Invalid student ID or course ID.");
            return false;
        }

        if (!course.getEnrolledStudents().contains(student)) {
            System.out.println("Student is not enrolled in this course.");
            return false;
        }

        course.getEnrolledStudents().remove(student); // Remove from enrolled list

        // Promote next waitlisted student if exists
        if (!course.getWaitlist().isEmpty()) {
            Student nextStudent = course.getWaitlist().poll(); // Get the first student from waitlist
            course.enrollStudent(nextStudent); // Enroll them
            System.out.println("Waitlisted student " + nextStudent + " has been promoted.");
        }

        System.out.println("Student successfully dropped from the course.");
        return true;
    }

    // List students by course (sorted by name)
    public void listStudentsByCourse(String courseId) {
        Course course = courses.get(courseId);
        if (course != null) {
            course.getEnrolledStudents().forEach(System.out::println);
        }
    }

    // List students by branch across all courses
    public void listStudentsByBranch(String branch) {
        students.values().stream()
                .filter(student -> student.getBranch().equals(branch))
                .forEach(System.out::println);
    }

    // List courses sorted by number of enrolled students (descending)
    public void listCoursesByEnrollment() {
        List<Course> courseList = new ArrayList<>(courses.values());
        courseList.sort((c1, c2) -> Integer.compare(c2.getEnrolledStudents().size(), c1.getEnrolledStudents().size()));
        courseList.forEach(course -> System.out.println(course.getCourseName() + " - " + course.getEnrolledStudents().size()));
    }

    // Add courses and students
    public void addCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }
}
