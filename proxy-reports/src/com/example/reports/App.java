package com.example.reports;

public class App {

    public static void main(String[] args) {
        User student = new User("Jasleen", "STUDENT");
        User faculty = new User("Prof. Noor", "FACULTY");
        User admin = new User("Kshitij", "ADMIN");

        // nothing gets loaded from disk yet — just metadata
        Report publicReport = new ReportProxy("R-101", "Orientation Plan", "PUBLIC");
        Report facultyReport = new ReportProxy("R-202", "Midterm Review", "FACULTY");
        Report adminReport = new ReportProxy("R-303", "Budget Audit", "ADMIN");

        ReportViewer viewer = new ReportViewer();

        System.out.println("=== CampusVault Demo ===");

        // public — anyone can see this
        viewer.open(publicReport, student);
        System.out.println();

        // student tries faculty report — should get denied
        viewer.open(facultyReport, student);
        System.out.println();

        // faculty opens their report — first time, so it loads from disk
        viewer.open(facultyReport, faculty);
        System.out.println();

        // admin opens admin report
        viewer.open(adminReport, admin);
        System.out.println();

        // same report again — should come from cache this time
        viewer.open(adminReport, admin);
    }
}
