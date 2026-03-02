// scanner just does attendance, no power switch needed
public class AttendanceScanner implements Scannable {
    @Override public int scanAttendance() { return 3; }
}
