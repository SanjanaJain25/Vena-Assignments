package PracticeSheet;

public class ShapeDemo {

    // Base class
    static class Shape {
        public void draw() {
            System.out.println("Drawing a shape...");
        }
    }

    // Subclass 1: Circle
    static class Circle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Circle");
        }
    }

    // Subclass 2: Square
    static class Square extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Square");
        }
    }

    // Subclass 3: Triangle
    static class Triangle extends Shape {
        @Override
        public void draw() {
            System.out.println("Drawing a Triangle");
        }
    }

    // Main method
    public static void main(String[] args) {
        // Array of base class type (polymorphism)
        Shape[] shapes = new Shape[3];

        // Store different shape objects
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Triangle();

        // Loop and call draw() on each object
        System.out.println("Calling draw() on each shape:");
        for (int i = 0; i < shapes.length; i++) {
            shapes[i].draw();  // Dynamic method dispatch
        }
    }
}

