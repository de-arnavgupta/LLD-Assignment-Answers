import java.util.*;

// just coordinates the steps now - parsing, validation, saving, printing are all separate
public class OnboardingService {

    private final InputParser parser;
    private final StudentValidator validator;
    private final StudentStore store;
    private final OnboardingPrinter printer;

    public OnboardingService(InputParser parser, StudentValidator validator,
                             StudentStore store, OnboardingPrinter printer) {
        this.parser = parser;
        this.validator = validator;
        this.store = store;
        this.printer = printer;
    }

    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String, String> kv = parser.parse(raw);

        List<String> errors = validator.validate(kv);
        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(store.count());
        StudentRecord rec = new StudentRecord(
            id,
            kv.get("name"),
            kv.get("email"),
            kv.get("phone"),
            kv.get("program")
        );

        store.save(rec);

        printer.printConfirmation(id, store.count(), rec);
    }
}
