package swt.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @Test
    void testAdd_positiveNumbers() {
        assertEquals(5.0, calc.add(2.0, 3.0));
    }

    @Test
    void testAdd_withNegativeNumber() {
        assertEquals(-1.0, calc.add(2.0, -3.0));
    }

    @Test
    void testSubtract() {
        assertEquals(1.0, calc.subtract(3.0, 2.0));
    }

    @Test
    void testMultiply() {
        assertEquals(6.0, calc.multiply(2.0, 3.0));
    }

    @Test
    void testMultiply_byZero() {
        assertEquals(0.0, calc.multiply(99.0, 0.0));
    }

    @Test
    void testDivide_normal() {
        assertEquals(2.5, calc.divide(5.0, 2.0));
    }

    @Test
    void testAdd_withZero() {
        assertEquals(42.0, calc.add(42.0, 0.0));
    }

    @Test
    void testDivide_resultLessThanOne() {
        assertEquals(0.5, calc.divide(1.0, 2.0));
    }

    // Exception-Test – das ist der wichtigste Test für A1!
    @Test
    void testDivide_byZero_throwsException() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> calc.divide(10.0, 0.0)
        );
        assertEquals("Division durch Null ist nicht erlaubt.", ex.getMessage());
    }
}