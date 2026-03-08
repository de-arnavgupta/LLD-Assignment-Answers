package com.example.reports;

// sits between the client and the real report
// handles access control, lazy loads the real report, and caches it for reuse
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();

    // null until the first authorized access triggers loading
    private RealReport cachedReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // block unauthorized users before doing any expensive work
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED: " + user.getName()
                    + " (" + user.getRole() + ") cannot view " + classification + " report [" + reportId + "]");
            return;
        }

        // lazy load - only create the real report on first authorized access
        if (cachedReport == null) {
            cachedReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[cache] reusing already-loaded report " + reportId);
        }

        cachedReport.display(user);
    }
}
