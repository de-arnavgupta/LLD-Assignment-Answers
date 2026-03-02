import java.util.*;

// stores all devices and lets us find them by what they can do
public class DeviceRegistry {
    private final List<SmartClassroomDevice> devices = new ArrayList<>();

    public void add(SmartClassroomDevice d) { devices.add(d); }

    // grab the first device that supports a given interface
    @SuppressWarnings("unchecked")
    public <T> T getFirst(Class<T> capability) {
        for (SmartClassroomDevice d : devices) {
            if (capability.isInstance(d)) return (T) d;
        }
        throw new IllegalStateException("No device supports: " + capability.getSimpleName());
    }

    // grab all devices that support a given interface
    @SuppressWarnings("unchecked")
    public <T> List<T> getAll(Class<T> capability) {
        List<T> result = new ArrayList<>();
        for (SmartClassroomDevice d : devices) {
            if (capability.isInstance(d)) result.add((T) d);
        }
        return result;
    }
}
