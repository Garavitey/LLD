package solid.Example1.GoodCode;

public class EmployeeCalculateSalary {
    public double calculateSalary(Employee e) { // method to calculate salary based on employee details
        // For demonstration, we will return a fixed salary based on employee ID
        if (e.getId() % 2 == 0) {
            return 50000.0; // Salary for even ID employees
        } else {
            return 45000.0; // Salary for odd ID employees
        }
    }

}
