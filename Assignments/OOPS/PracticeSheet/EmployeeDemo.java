package PracticeSheet;

public class EmployeeDemo {

    // Abstract class
    abstract static class Employee {
        String name;
        String id;

        // Constructor
        public Employee(String name, String id) {
            this.name = name;
            this.id = id;
        }

        // Abstract methods
        public abstract double calculateSalary();
        public abstract void getDetails();
    }

    // Full-time employee class
    static class FullTimeEmployee extends Employee {
        double monthlySalary;

        public FullTimeEmployee(String name, String id, double monthlySalary) {
            super(name, id);
            this.monthlySalary = monthlySalary;
        }

        @Override
        public double calculateSalary() {
            return monthlySalary;
        }

        @Override
        public void getDetails() {
            System.out.println("Full-Time Employee");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Monthly Salary: $" + calculateSalary());
        }
    }

    // Freelancer class
    static class Freelancer extends Employee {
        double hourlyRate;
        int hoursWorked;

        public Freelancer(String name, String id, double hourlyRate, int hoursWorked) {
            super(name, id);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculateSalary() {
            return hourlyRate * hoursWorked;
        }

        @Override
        public void getDetails() {
            System.out.println("Freelancer");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Total Salary (Hourly): $" + calculateSalary());
        }
    }

    // Main method
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Sanjana", "EMP001", 6000);
        Employee e2 = new Freelancer("Ranu", "EMP002", 50, 120);

        System.out.println("--- Employee Details ---\n");

        e1.getDetails();
        System.out.println();
        e2.getDetails();
    }
}

