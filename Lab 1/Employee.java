import java.util.Scanner;
abstract class Employee { // Parent employee function
    private String name, address, phone; // Main variable data
    private double salary; // Salary variable data
    
    Employee() { // Empty constructor
        SetName("");
        SetAddress("");
        SetPhone("");
    }

    Employee(String name, String address, String phone) { // Constructor with main variables passed (not )
        SetName(name);
        SetAddress(address);
        SetPhone(phone);
    }

    // Set functions for each of the variables
    public void SetName(String name) { this.name = name; }
    public void SetAddress(String address) {this.address = address;}
    public void SetPhone(String phone) {this.phone = phone;}
    public void SetSalary(double salary) {this.salary = salary;}

    // Get functions for each of the variables
    public String GetName() { return name;}
    public String GetAddress() {return address;}
    public String GetPhone() {return phone;}
    public double GetSalary() { return salary;}

    // Abstract functions to ensure functionality
    public abstract void CapturePaymentData(Scanner inData);
    public abstract int GetType();

    // Function to capture basic data (name, address, phone number)
    public void CaptureBasicData(Scanner inData) {
        System.out.print("Please enter the employee's name: ");
        inData.nextLine(); // Skip to next line (offset an error)
        SetName(inData.nextLine());
        System.out.print("Please enter " + this.GetName() + "'s address: ");
        SetAddress(inData.nextLine());
        System.out.print("Finally, enter their phone number: ");
        SetPhone(inData.nextLine());
    }
}