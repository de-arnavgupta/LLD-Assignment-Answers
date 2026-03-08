package com.example.reports;

// both RealReport and ReportProxy implement this
public interface Report {
    void display(User user);
}
