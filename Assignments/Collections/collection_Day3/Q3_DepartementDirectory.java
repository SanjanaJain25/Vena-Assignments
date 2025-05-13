package collection_Day3;

import java.util.*;


class Employee {
    String name;
    String department;
    double salary;


    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // employee details
    public String toString() {
        return name + " | " + department + " | ₹" + salary;
    }
}

// Main class to handle directory
public class Q3_DepartementDirectory {

    // Map to hold department-wise employee list
    Map<String, List<Employee>> departmentMap = new HashMap<>();

    // Method to add employee to map
    void addEmployee(Employee emp) {
        departmentMap.putIfAbsent(emp.department, new ArrayList<>());
        departmentMap.get(emp.department).add(emp);
    }

    // Method to sort each department's employee list by salary descending
    void sortDepartmentsBySalary() {
        for (List<Employee> empList : departmentMap.values()) {
            empList.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));
        }
    }

    // Method to get top N paid employees from all departments
    List<Employee> getTopNPaidEmployees(int n) {
        List<Employee> allEmployees = new ArrayList<>();

        // Combine all employees from all departments
        for (List<Employee> list : departmentMap.values()) {
            allEmployees.addAll(list);
        }

        // Sort by salary descending
        allEmployees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        // Get top N
        return allEmployees.subList(0, Math.min(n, allEmployees.size()));
    }


    void displayAll() {
        for (String dept : departmentMap.keySet()) {
            System.out.println("\nDepartment: " + dept);
            for (Employee emp : departmentMap.get(dept)) {
                System.out.println("  " + emp);
            }
        }
    }


    public static void main(String[] args) {
        Q3_DepartementDirectory directory = new Q3_DepartementDirectory();


        directory.addEmployee(new Employee("Vaishali", "HR", 50000));
        directory.addEmployee(new Employee("Abhishek", "IT", 80000));
        directory.addEmployee(new Employee("Saurabh", "IT", 60000));
        directory.addEmployee(new Employee("Aditya", "Finance", 90000));
        directory.addEmployee(new Employee("Chirag", "HR", 70000));
        directory.addEmployee(new Employee("Rajesh", "Finance", 85000));


        directory.sortDepartmentsBySalary();
        directory.displayAll();


        System.out.println("\nTop 3 Paid Employees:");
        List<Employee> topPaid = directory.getTopNPaidEmployees(3);
        for (Employee e : topPaid) {
            System.out.println(e);
        }
    }
}

