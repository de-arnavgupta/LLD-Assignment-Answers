import java.util.List;

// abstraction for storage so we're not locked into FakeDb
public interface StudentStore {
    void save(StudentRecord r);
    int count();
    List<StudentRecord> all();
}
