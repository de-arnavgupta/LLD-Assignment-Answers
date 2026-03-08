package com.example.reports;

public class App {

    public static void main(String[] args) {
        User student = new User("Jasleen", "STUDENT");
        User faculty = new User("Prof. Noor", "FACULTY");
        User admin = new User("Kshitij", "ADMIN");

        // create proxied reports - no disk loading happens yet
        Report publicReport = new ReportProxy("R-101", "Orientation Plan", "PUBLIC");
        Report facultyReport = new ReportProxy("R-202", "Midterm Review", "FACULTY");
        Report adminReport = new ReportProxy("R-303", "Budget Audit", "ADMIN");

        ReportViewer viewer = new ReportViewer();

        System.out.println("=== CampusVault Demo ===");

        // student can see public reports
        viewer.open(publicReport, student);
        System.out.println();

        // student blocked from faculty report
        viewer.open(facultyReport, student);
        System.out.println();

        // faculty can see faculty report - triggers lazy load
        viewer.open(facultyReport, faculty);
        System.out.println();

        // admin can see admin report - triggers lazy load
        viewer.open(adminReport, admin);
        System.out.println();

        // second view of same admin report - uses cached version
        viewer.open(adminReport, admin);
    }
}
