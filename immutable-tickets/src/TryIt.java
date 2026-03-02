import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

// quick demo to show tickets can't be changed after creation
public class TryIt {

    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket original = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + original);

        // assign gives back a new ticket, original doesn't change
        IncidentTicket assigned = service.assign(original, "agent@example.com");
        System.out.println("\nAfter assign (new ticket): " + assigned);
        System.out.println("Original still the same:   " + original);

        // same thing with escalation
        IncidentTicket escalated = service.escalateToCritical(assigned);
        System.out.println("\nAfter escalation (new ticket): " + escalated);
        System.out.println("Assigned still the same:       " + assigned);

        // try to sneak a tag in from outside
        List<String> tags = escalated.getTags();
        try {
            tags.add("HACKED_FROM_OUTSIDE");
            System.out.println("BUG: external mutation worked");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nCan't modify tags from outside, list is locked down");
        }

        System.out.println("Tags still intact: " + escalated.getTags());
    }
}
