package com.example.reports;

// talks to the Report interface — doesn't care if it's a proxy or real
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
