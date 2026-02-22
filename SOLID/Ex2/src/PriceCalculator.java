import java.util.*;

// extracted pricing logic out of CafeteriaSystem so it can be tested separately
public class PriceCalculator {

    private final Map<String, MenuItem> menu;

    public PriceCalculator(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public double lineTotal(OrderLine line) {
        MenuItem item = menu.get(line.itemId);
        return item.price * line.qty;
    }

    public double subtotal(List<OrderLine> lines) {
        double sum = 0.0;
        for (OrderLine l : lines) {
            sum += lineTotal(l);
        }
        return sum;
    }

    public MenuItem getItem(String itemId) {
        return menu.get(itemId);
    }
}
