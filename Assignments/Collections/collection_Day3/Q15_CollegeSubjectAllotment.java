package collection_Day3;

import java.util.*;


public class Q15_CollegeSubjectAllotment {


    Map<String, List<String>> studentSubjects = new HashMap<>();


    Map<String, List<String>> subjectStudents = new HashMap<>();


    public void allotSubjects(String studentName, List<String> subjects) {

        studentSubjects.put(studentName, subjects);


        for (String subject : subjects) {

            subjectStudents.putIfAbsent(subject, new ArrayList<>());
            subjectStudents.get(subject).add(studentName);
        }
    }

    //  display all subjects allotted to a student
    public void displayStudentSubjects(String studentName) {
        List<String> subjects = studentSubjects.get(studentName);
        if (subjects != null) {
            System.out.println(studentName + " has opted for the following subjects: ");
            for (String subject : subjects) {
                System.out.println(subject);
            }
        } else {
            System.out.println(studentName + " has not opted for any subjects.");
        }
    }

    // display all students who have opted for a specific subject
    public void displayStudentsForSubject(String subject) {
        List<String> students = subjectStudents.get(subject);
        if (students != null) {
            System.out.println("Students who opted for " + subject + ":");
            for (String student : students) {
                System.out.println(student);
            }
        } else {
            System.out.println("No students have opted for " + subject);
        }
    }

    public static void main(String[] args) {
        Q15_CollegeSubjectAllotment system = new Q15_CollegeSubjectAllotment();

        // Allot subjects to students
        system.allotSubjects("Sanjana", Arrays.asList("Math", "Science", "English"));
        system.allotSubjects("Pragya", Arrays.asList("History", "Math", "Computer Science"));
        system.allotSubjects("Kratika", Arrays.asList("Math", "Computer Science", "English"));
        system.allotSubjects("Ranu", Arrays.asList("History", "Biology"));


        system.displayStudentSubjects("Sanjana");


        system.displayStudentsForSubject("Math");


        system.displayStudentsForSubject("History");
    }
}
