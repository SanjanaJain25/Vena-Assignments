package collectionFrameworkAssignment.main;

import collectionFrameworkAssignment.service.RegistrationSystem;
import collectionFrameworkAssignment.Student;
import collectionFrameworkAssignment.model.Course;

public class Main {
    public static void main(String[] args) {
        // Create registration system
        RegistrationSystem system = new RegistrationSystem();

        // Create students
        Student s1 = new Student("S001", "sanjana", "sanjana@gmail.com", "2023", "CS");
        Student s2 = new Student("S002", "Ranu", "ranu@gmail.com", "2022", "IT");
        Student s3 = new Student("S003", "Riya", "riya@gmail.com", "2023", "CS");
        Student s4 = new Student("S004", "Charu", "charu@gmail.com", "2021", "CS");

        // Add students to system
        system.addStudent(s1);
        system.addStudent(s2);
        system.addStudent(s3);
        system.addStudent(s4);

        // Create courses
        Course course1 = new Course("CS101", "Java Programming", "Dr. Smith", 2, 3);
        Course course2 = new Course("CS102", "Database Systems", "Dr. Johnson", 2, 4);

        // Add courses to system
        system.addCourse(course1);
        system.addCourse(course2);

        // Register students to courses
        system.registerStudentToCourse("S001", "CS101");
        system.registerStudentToCourse("S002", "CS101");
        system.registerStudentToCourse("S003", "CS101"); // Should be waitlisted
        system.registerStudentToCourse("S004", "CS102");

        // Drop a course and promote waitlisted students
        system.dropCourse("S002", "CS101");

        // List students in a specific course
        system.listStudentsByCourse("CS101");

        // List students in a particular branch (e.g., CS)
        system.listStudentsByBranch("CS");

        // List courses sorted by number of enrolled students
        system.listCoursesByEnrollment();
    }
}
