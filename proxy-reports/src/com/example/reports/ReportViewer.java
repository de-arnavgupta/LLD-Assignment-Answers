package com.example.reports;

// viewer now depends on the Report interface, not on any concrete class
// this way it works with proxied reports transparently
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
