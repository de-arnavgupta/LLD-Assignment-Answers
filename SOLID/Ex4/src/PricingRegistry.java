import java.util.*;

// maps room types and addons to their pricing - replaces the old switch/if-else
public class PricingRegistry {

    private final Map<Integer, RoomPricing> roomPricings = new HashMap<>();
    private final Map<AddOn, AddOnPricing> addOnPricings = new HashMap<>();

    public void registerRoom(int roomType, RoomPricing pricing) {
        roomPricings.put(roomType, pricing);
    }

    public void registerAddOn(AddOn addOn, AddOnPricing pricing) {
        addOnPricings.put(addOn, pricing);
    }

    public RoomPricing getRoomPricing(int roomType) {
        return roomPricings.get(roomType);
    }

    public AddOnPricing getAddOnPricing(AddOn addOn) {
        return addOnPricings.get(addOn);
    }
}

