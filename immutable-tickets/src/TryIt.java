import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

// demo showing that tickets are now immutable
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket original = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + original);

        // assign returns a NEW ticket — original is untouched
        IncidentTicket assigned = service.assign(original, "agent@example.com");
        System.out.println("\nAfter assign (new ticket): " + assigned);
        System.out.println("Original still the same:   " + original);

        // escalate also returns a new ticket
        IncidentTicket escalated = service.escalateToCritical(assigned);
        System.out.println("\nAfter escalation (new ticket): " + escalated);
        System.out.println("Assigned still the same:       " + assigned);

        // try to modify tags from outside — should throw UnsupportedOperationException
        List<String> tags = escalated.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("BUG: external mutation worked");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCan't modify tags from outside — list is unmodifiable (good)");
        }

        System.out.println("Tags still intact: " + escalated.getTags());
    }
}
