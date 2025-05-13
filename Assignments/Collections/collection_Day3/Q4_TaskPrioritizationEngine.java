package collection_Day3;

import java.util.*;


class Task {
    String name;
    int priority; //
    Date deadline;

    Task(String name, int priority, Date deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String toString() {
        return name + " | Priority: " + priority + " | Deadline: " + deadline;
    }
}


public class Q4_TaskPrioritizationEngine {

    public static void main(String[] args) {
        //   Comparator for task sorting
        Comparator<Task> taskComparator = new Comparator<Task>() {
            public int compare(Task t1, Task t2) {
                int deadlineCompare = t1.deadline.compareTo(t2.deadline); // Earlier deadline = higher priority
                if (deadlineCompare == 0) {
                    return Integer.compare(t2.priority, t1.priority); // Higher priority value first
                }
                return deadlineCompare;
            }
        };

        // PriorityQueue with custom comparator
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(taskComparator);


        Calendar cal = Calendar.getInstance();

        cal.set(2025, Calendar.MAY, 10);
        taskQueue.add(new Task("Submit Report", 4, cal.getTime()));

        cal.set(2025, Calendar.MAY, 8);
        taskQueue.add(new Task("Code Review", 3, cal.getTime()));

        cal.set(2025, Calendar.MAY, 8);
        taskQueue.add(new Task("Fix Critical Bug", 5, cal.getTime()));

        cal.set(2025, Calendar.MAY, 15);
        taskQueue.add(new Task("Design Meeting", 2, cal.getTime()));


        System.out.println("=== Task Execution Order ===");
        while (!taskQueue.isEmpty()) {
            Task next = taskQueue.poll(); // Gets and removes the highest-priority task
            System.out.println(next);
        }
    }
}
