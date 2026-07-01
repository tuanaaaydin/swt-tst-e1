package swt.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<CartItem> items = new ArrayList<>();

    public double getTotal() {
        return 0.0;
    }

    public record CartItem(String name, double price, int quantity) {}
}