package collection_Day3;

import java.util.*;

public class Q8_EmployeeHierarchy {

    // Main hierarchy map: Manager -> (Level -> List of Employees)
    Map<String, TreeMap<Integer, List<String>>> hierarchy = new HashMap<>();


    public void addEmployee(String manager, int level, String employeeName) {
        hierarchy.putIfAbsent(manager, new TreeMap<>());

        TreeMap<Integer, List<String>> levelMap = hierarchy.get(manager);
        levelMap.putIfAbsent(level, new ArrayList<>());

        levelMap.get(level).add(employeeName);
    }


    public void displayHierarchy() {
        for (String manager : hierarchy.keySet()) {
            System.out.println("\nManager: " + manager);

            TreeMap<Integer, List<String>> levelMap = hierarchy.get(manager);
            for (Integer level : levelMap.keySet()) {
                System.out.println("  Level " + level + ": " + levelMap.get(level));
            }
        }
    }


    public static void main(String[] args) {
        Q8_EmployeeHierarchy org = new Q8_EmployeeHierarchy();


        org.addEmployee("Rajesh", 1, "John");
        org.addEmployee("Rajesh", 2, "Mary");
        org.addEmployee("Rajesh", 3, "Steve");

        org.addEmployee("Farhad", 1, "Ravi");
        org.addEmployee("Farhad", 2, "Aman");
        org.addEmployee("Farhad", 2, "Simran");

        org.addEmployee("Abhishek", 1, "Pooja");


        org.displayHierarchy();
    }
}
