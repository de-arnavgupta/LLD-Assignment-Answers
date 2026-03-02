package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

// creates tickets and handles "updates" by returning new instances
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // validation is inside build(), we just set the fields
        return new IncidentTicket.Builder(id, reporterEmail, title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(List.of("NEW"))
                .build();
    }

    // makes a new ticket with CRITICAL priority, original is left alone
    public IncidentTicket escalateToCritical(IncidentTicket t) {
        List<String> updatedTags = new ArrayList<>(t.getTags());
        updatedTags.add("ESCALATED");

        return t.toBuilder()
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    // assign someone to the ticket (returns a new copy)
    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
