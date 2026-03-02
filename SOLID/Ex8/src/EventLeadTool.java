// event lead can only manage events, nothing else
public class EventLeadTool implements EventOps {
    private final EventPlanner planner;
    public EventLeadTool(EventPlanner planner) { this.planner = planner; }

    @Override public void createEvent(String name, double budget) { planner.create(name, budget); }
    @Override public int getEventsCount() { return planner.count(); }
}
