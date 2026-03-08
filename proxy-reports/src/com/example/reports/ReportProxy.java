package com.example.reports;

// proxy that checks permissions and avoids loading the report until actually needed
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();

    private RealReport cachedReport; // stays null until first legit access

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        // check permission first
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED: " + user.getName()
                    + " (" + user.getRole() + ") cannot view " + classification + " report [" + reportId + "]");
            return;
        }

        // load only on first access, reuse after that
        if (cachedReport == null) {
            cachedReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[cache] reusing already-loaded report " + reportId);
        }

        cachedReport.display(user);
    }
}
