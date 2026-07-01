package swt.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        items.add(new CartItem(name, price, quantity));
    }

    public double getTotal() {
        return items.stream()
                    .mapToDouble(item -> item.price() * item.quantity())
                    .sum();
    }

    public int getItemCount() {
        return items.size();
    }

    public record CartItem(String name, double price, int quantity) {}
}
