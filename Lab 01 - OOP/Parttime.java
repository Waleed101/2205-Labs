import java.util.Scanner;
public class Parttime extends Employee { // Class for parttime employees, inherits the functionality in Employee
    // Custom variables
    private double hourly, noHours;

    Parttime() { // Empty constructor
        super();
    }

    Parttime(String sName, String sAddress, String sPhone) { // Constructor with main variables
        super(sName, sAddress, sPhone);
    }

    // Set functions for each of the individual custom variables
    public void SetHourlyRate(double sHourly) {hourly = sHourly;}
    public void SetNumberOfHours(double sNoHours) {noHours = sNoHours;}

    // Get functions for each of the individual custom variables
    public double GetHourlyRate() {return hourly;}
    public double GetNumberOfHours() {return noHours;}
    public int GetType() { return 1; } // 1 represents part time

    // Custom function to capture specific payment data
    public void CapturePaymentData(Scanner inData) {
        System.out.print("Please enter the hourly rate for " + super.GetName() + ": $");
        SetHourlyRate(inData.nextDouble());
        System.out.print("Please enter the number of hours worked for " + super.GetName() + ":");
        SetNumberOfHours(inData.nextDouble());
        super.SetSalary(hourly * noHours); // Setting the salary of this individual employee
    }
}
