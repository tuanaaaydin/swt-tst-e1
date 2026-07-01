package swt.shop;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<CartItem> items = new ArrayList<>();

    public void addItem(String name, double price, int quantity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Produktname darf nicht leer sein.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Preis darf nicht negativ sein.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Menge muss groesser als 0 sein.");
        }
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

    public void clear() {
        items.clear();
    }

    public record CartItem(String name, double price, int quantity) {}
}