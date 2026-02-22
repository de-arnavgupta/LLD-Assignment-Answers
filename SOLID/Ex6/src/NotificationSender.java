// base class for all senders - send() returns SendResult instead of throwing
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract SendResult send(Notification n);
}
