package swt.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testEmptyCart_totalIsZero() {
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    void testAddItem_singleItem() {
        cart.addItem("Apfel", 0.99, 1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    void testGetTotal_singleItem() {
        cart.addItem("Brot", 2.50, 2);
        assertEquals(5.00, cart.getTotal(), 0.001);
    }

    @Test
    void testGetTotal_multipleItems() {
        cart.addItem("Milch", 1.20, 3);
        cart.addItem("Käse", 3.50, 1);
        assertEquals(7.10, cart.getTotal(), 0.001);
    }
    @Test
    void testClear_resetsCart() {
        cart.addItem("Wasser", 0.50, 5);
        cart.clear();
        assertEquals(0, cart.getItemCount());
        assertEquals(0.0, cart.getTotal());
    }

    @Test
    void testAddItem_emptyName_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("", 1.00, 1));
    }

    @Test
    void testAddItem_negativePrice_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("Apfel", -1.00, 1));
    }

    @Test
    void testAddItem_zeroQuantity_throwsException() {
        assertThrows(IllegalArgumentException.class,
            () -> cart.addItem("Apfel", 1.00, 0));
    }
}