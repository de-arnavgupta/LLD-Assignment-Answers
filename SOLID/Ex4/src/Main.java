import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");

        // setup pricing for each room type and addon
        PricingRegistry registry = new PricingRegistry();
        registry.registerRoom(LegacyRoomTypes.SINGLE, new SingleRoomPricing());
        registry.registerRoom(LegacyRoomTypes.DOUBLE, new DoubleRoomPricing());
        registry.registerRoom(LegacyRoomTypes.TRIPLE, new TripleRoomPricing());
        registry.registerRoom(LegacyRoomTypes.DELUXE, new DeluxeRoomPricing());
        registry.registerAddOn(AddOn.MESS, new MessAddOnPricing());
        registry.registerAddOn(AddOn.LAUNDRY, new LaundryAddOnPricing());
        registry.registerAddOn(AddOn.GYM, new GymAddOnPricing());

        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), registry);
        calc.process(req);
    }
}
