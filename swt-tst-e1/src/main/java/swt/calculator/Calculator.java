package swt.calculator;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Dividiert a durch b.
     * @throws IllegalArgumentException wenn b == 0
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division durch Null ist nicht erlaubt.");
        }
        return a / b;
    }
}