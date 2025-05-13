package collection_Day3;

import java.util.*;


class Product {
    int id;
    String name;
    double price;
    double rating;
    int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: ₹" + price + ", Rating: " + rating + ", Stock: " + stock;
    }
}

public class Q5_ProductCatalogSystem {

    public static void main(String[] args) {


        TreeMap<Integer, Product> productMap = new TreeMap<>();

        // Adding products
        productMap.put(101, new Product(101, "Laptop", 75000, 4.5, 10));
        productMap.put(102, new Product(102, "Mobile", 25000, 4.7, 25));
        productMap.put(103, new Product(103, "Keyboard", 1500, 4.2, 50));
        productMap.put(104, new Product(104, "Monitor", 12000, 4.7, 20));
        productMap.put(105, new Product(105, "Mouse", 700, 4.5, 60));


        List<Product> productList = new ArrayList<>(productMap.values());

        // Sort by rating (descending), then by name (alphabetical)
        Collections.sort(productList, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                if (Double.compare(p2.rating, p1.rating) != 0) {
                    return Double.compare(p2.rating, p1.rating); // Descending rating
                } else {
                    return p1.name.compareTo(p2.name); // Alphabetical name
                }
            }
        });

        // Step 3: Print sorted products
        System.out.println("📦 Sorted Product Catalog:");
        for (Product p : productList) {
            System.out.println(p);
        }
    }
}
