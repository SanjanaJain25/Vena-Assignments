package PracticeSheet;

public class StudentRegistry {

    static class Student {
        private static int counter = 0; // Static counter shared among all students
        private int id;                // Unique ID for each student
        private String name;          // Name of the student

        // Constructor
        public Student(String name) {
            this.name = name;
            counter++;            // Increment counter whenever a student is created
            this.id = counter;    // Assign current counter value as unique ID
        }

        // Method to display student info
        public void displayInfo() {
            System.out.println("Student ID: " + id + ", Name: " + name);
        }

        // Static method to show total students
        public static void displayTotalStudents() {
            System.out.println("Total number of students: " + counter);
        }
    }

    // Main method
    public static void main(String[] args) {
        Student s1 = new Student("Sanjana");
        Student s2 = new Student("Ranu");
        Student s3 = new Student("Kratika");
        Student s4 = new Student ("Pragya");

        // Display individual student info
        s1.displayInfo();
        s2.displayInfo();
        s3.displayInfo();
        s4.displayInfo();

        // Display total students
        Student.displayTotalStudents();
    }
}
