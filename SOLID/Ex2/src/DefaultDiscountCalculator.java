// fallback - no discount for unknown customer types
public class DefaultDiscountCalculator implements DiscountCalculator {
    @Override
    public double discountAmount(double subtotal, int distinctLines) {
        return 0.0;
    }
}

