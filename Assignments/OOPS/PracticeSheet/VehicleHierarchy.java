package PracticeSheet;

public class VehicleHierarchy {

    // Base class
    static class Vehicle {
        private double speed;
        private double fuelCapacity;

        public Vehicle(double speed, double fuelCapacity) {
            this.speed = speed;
            this.fuelCapacity = fuelCapacity;
        }

        public double getSpeed() {
            return speed;
        }

        public double getFuelCapacity() {
            return fuelCapacity;
        }

        // Placeholder method, can be overridden
        public double getMileage() {
            return 0;
        }
    }

    // Subclass Car
    static class Car extends Vehicle {
        public Car(double speed, double fuelCapacity) {
            super(speed, fuelCapacity);
        }

        // Mileage formula for Car
        @Override
        public double getMileage() {
            // Simple example: mileage = (speed * 0.5) / fuel capacity
            return (getSpeed() * 0.5) / getFuelCapacity();
        }
    }

    // Subclass Truck
    static class Truck extends Vehicle {
        public Truck(double speed, double fuelCapacity) {
            super(speed, fuelCapacity);
        }

        // Mileage formula for Truck
        @Override
        public double getMileage() {
            // Trucks usually have lower mileage
            return (getSpeed() * 0.3) / getFuelCapacity();
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Car car = new Car(100, 40);  // speed=100 km/h, fuel=40 liters
        Truck truck = new Truck(80, 100); // speed=80 km/h, fuel=100 liters

        System.out.println("Car Mileage: " + car.getMileage() + " km/l");
        System.out.println("Truck Mileage: " + truck.getMileage() + " km/l");
    }
}
