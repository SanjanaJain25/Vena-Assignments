package PracticeSheet;

public class CalculatorLockdown {

    // Superclass with a final method
    static class BasicCalculator {
        public final int add(int a, int b) {
            return a + b;
        }
    }

    // Subclass trying to override add()
    static class SmartCalculator extends BasicCalculator {

        //  This will cause a compile-time error
        /*
        @Override
        public int add(int a, int b) {
            return a + b + 1; // Invalid: Cannot override final method
        }
        */

        // New method: subtraction
        public int subtract(int a, int b) {
            return a - b;
        }
    }

    // Main method
    public static void main(String[] args) {
        SmartCalculator calc = new SmartCalculator();

        // Using inherited final method
        System.out.println("Addition: " + calc.add(10, 5));

        // Using new method
        System.out.println("Subtraction: " + calc.subtract(10, 5));
    }
}

