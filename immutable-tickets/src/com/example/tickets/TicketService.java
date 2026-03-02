package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

// service that creates and "updates" tickets without ever mutating them
public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        // builder handles all validation — no need to check here
        return new IncidentTicket.Builder(id, reporterEmail, title)
                .priority("MEDIUM")
                .source("CLI")
                .customerVisible(false)
                .tags(List.of("NEW"))
                .build();
    }

    // returns a new ticket — the original stays unchanged
    public IncidentTicket escalateToCritical(IncidentTicket t) {
        List<String> updatedTags = new ArrayList<>(t.getTags());
        updatedTags.add("ESCALATED");

        return t.toBuilder()
                .priority("CRITICAL")
                .tags(updatedTags)
                .build();
    }

    // returns a new ticket with the assignee set
    public IncidentTicket assign(IncidentTicket t, String assigneeEmail) {
        return t.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }
}
