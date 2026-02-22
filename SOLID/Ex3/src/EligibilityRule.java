// common interface for all eligibility rules
public interface EligibilityRule {
    // returns null if passed, or a reason string if failed
    String check(StudentProfile student);
}

