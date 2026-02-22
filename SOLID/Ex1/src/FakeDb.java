import java.util.*;

// implements StudentStore so the service depends on the interface, not this directly
public class FakeDb implements StudentStore {
    private final List<StudentRecord> rows = new ArrayList<>();

    @Override
    public void save(StudentRecord r) { rows.add(r); }
    @Override
    public int count() { return rows.size(); }
    @Override
    public List<StudentRecord> all() { return Collections.unmodifiableList(rows); }
}
