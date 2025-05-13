package PracticeSheet;

public class InventorySystem {

    // Product class
    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price);
        }
    }

    // Store class
    static class Store {
        Product[] products = new Product[5];
        int count = 0;

        void addProduct(Product product) {
            if (count < products.length) {
                products[count] = product;
                count++;
            } else {
                System.out.println("Store is full.");
            }
        }

        void displayAll() {
            System.out.println("All Products:");
            for (int i = 0; i < count; i++) {
                products[i].display();
            }
        }

        void findMostExpensive() {
            if (count == 0) return;

            Product expensive = products[0];
            for (int i = 1; i < count; i++) {
                if (products[i].price > expensive.price) {
                    expensive = products[i];
                }
            }
            System.out.println("\nMost Expensive Product:");
            expensive.display();
        }

        void searchByName(String searchName) {
            boolean found = false;
            for (int i = 0; i < count; i++) {
                if (products[i].name.equalsIgnoreCase(searchName)) {
                    System.out.println("\nProduct Found:");
                    products[i].display();
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("\nProduct not found.");
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        Store store = new Store();

        // Adding products
        store.addProduct(new Product(1, "Laptop", 700));
        store.addProduct(new Product(2, "Phone", 500));
        store.addProduct(new Product(3, "Tablet", 300));
        store.addProduct(new Product(4, "Mouse", 50));

        // Display all products
        store.displayAll();

        // Find most expensive
        store.findMostExpensive();

        // Search for a product by name
        store.searchByName("Tablet");
    }
}
