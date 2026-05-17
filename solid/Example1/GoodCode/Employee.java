package solid.Example1.GoodCode;

public class Employee {
    // this class follows the Single Responsibility Principle by only containing employee details and related methods
    private int id; // Employee ID
    private String name; // Employee Name
    private String address; // Employee Address

    public Employee(int id, String name, String address) { // constructor to initialize employee details
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // getters and setters for employee details
    public int getId() {
        return id;  
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
