package solid.Example1.ProblemCode;

public class Employee {
    private int id; // Employee ID
    private String name; // Employee Name

    public Employee(int id, String name) { // constructor to initialize employee details
        this.id = id;
        this.name = name;
    }

    public void printPerformace() { // method to print employee performance
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Performance: Excellent"); // hardcoded performance for demonstration
    }
}
