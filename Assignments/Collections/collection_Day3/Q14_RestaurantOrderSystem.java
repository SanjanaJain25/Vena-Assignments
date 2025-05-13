package collection_Day3;

import java.util.*;


class Order {
    String orderId;
    String customerName;
    String dishName;

    public Order(String orderId, String customerName, String dishName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Dish: " + dishName;
    }
}

public class Q14_RestaurantOrderSystem {


    Deque<Order> currentOrders = new LinkedList<>();


    List<Order> orderHistory = new ArrayList<>();

    // to add a new order at the front (or end) of the deque
    public void addOrder(Order order, boolean addToFront) {
        if (addToFront) {
            currentOrders.addFirst(order); // Add to the front
        } else {
            currentOrders.addLast(order); // Add to the end
        }
    }


    public Order removeOrder(boolean removeFromFront) {
        if (removeFromFront) {
            Order order = currentOrders.removeFirst(); // Remove from the front
            orderHistory.add(order); // Add to history
            return order;
        } else {
            Order order = currentOrders.removeLast(); // Remove from the end
            orderHistory.add(order); // Add to history
            return order;
        }
    }


    public void displayCurrentOrders() {
        System.out.println("\nCurrent Orders:");
        for (Order order : currentOrders) {
            System.out.println(order);
        }
    }


    public void displayOrderHistory() {
        System.out.println("\nOrder History:");
        for (Order order : orderHistory) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {
        Q14_RestaurantOrderSystem system = new Q14_RestaurantOrderSystem();


        Order order1 = new Order("O001", "Sanjana", "Pizza");
        Order order2 = new Order("O002", "Ranu", "Pasta");
        Order order3 = new Order("O003", "Pragya", "Burger");

        // Adding orders to the deque
        system.addOrder(order1, false); // Add to end
        system.addOrder(order2, true);  // Add to front
        system.addOrder(order3, false); // Add to end

        // Display current orders
        system.displayCurrentOrders();

        // Removing and processing orders (from front)
        system.removeOrder(true); // Remove from front and add to history
        system.displayCurrentOrders();

        // Display order history
        system.displayOrderHistory();
    }
}
