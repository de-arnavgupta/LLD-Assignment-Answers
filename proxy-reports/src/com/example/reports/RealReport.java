package com.example.reports;

// the actual report that does the expensive disk load
// this is the "real subject" in the proxy pattern
public class RealReport implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final String content;

    public RealReport(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        // expensive load happens once during construction
        this.content = loadFromDisk();
    }

    @Override
    public void display(User user) {
        System.out.println("REPORT -> id=" + reportId
                + " title=" + title
                + " classification=" + classification
                + " openedBy=" + user.getName());
        System.out.println("CONTENT: " + content);
    }

    public String getClassification() {
        return classification;
    }

    private String loadFromDisk() {
        System.out.println("[disk] loading report " + reportId + " ...");
        try { Thread.sleep(120); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        return "Internal report body for " + title;
    }
}
