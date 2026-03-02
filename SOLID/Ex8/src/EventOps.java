// stuff the event lead can do
public interface EventOps extends ClubAdminTools {
    void createEvent(String name, double budget);
    int getEventsCount();
}

