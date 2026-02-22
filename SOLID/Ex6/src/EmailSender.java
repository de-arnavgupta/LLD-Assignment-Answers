// caps body at 40 chars for display, returns SendResult
public class EmailSender extends NotificationSender {
    private static final int MAX_BODY_LENGTH = 40;

    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public SendResult send(Notification n) {
        String body = n.body;
        if (body.length() > MAX_BODY_LENGTH) body = body.substring(0, MAX_BODY_LENGTH);
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
        return SendResult.ok("email sent");
    }
}
