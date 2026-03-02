// returns a hardcoded driver for now
public class DriverAllocator implements DriverAlloc {
    @Override
    public String allocate(String studentId) {
        return "DRV-17";
    }
}
