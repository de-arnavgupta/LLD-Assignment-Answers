import java.util.*;

// uses a registry to look up room/addon prices instead of switch-case
public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final PricingRegistry registry;

    public HostelFeeCalculator(FakeBookingRepo repo, PricingRegistry registry) {
        this.repo = repo;
        this.registry = registry;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        RoomPricing room = registry.getRoomPricing(req.roomType);
        double base = room.basePrice();

        double add = 0.0;
        for (AddOn a : req.addOns) {
            AddOnPricing addOnPricing = registry.getAddOnPricing(a);
            add += addOnPricing.price();
        }

        return new Money(base + add);
    }
}
