import java.util.Scanner;
public class Fulltime extends Employee { // Class for full time employees inherits from Employee function
    // Custom variables
    private double monthly, tax;

    Fulltime() { // Empty constructor
        super();
    }

    Fulltime(String sName, String sAddress, String sPhone) { // Constructor with main variables
        super(sName, sAddress, sPhone);
    }

    // Set functions for each of the individual custom variables
    public void SetMonthly(double sMonthly) {monthly = sMonthly;}
    public void SetTax(double sTax) {tax = sTax;}

    // Get functions for each of the individual custom variable
    public double GetMonthly() {return monthly;}
    public double GetTax() {return tax;}
    public int GetType() { return 2; } // 2 represents full time

    // Function to capture custom payment data
    public void CapturePaymentData(Scanner inData) {
        System.out.print("Please enter the monthly salary for " + super.GetName() + ": $");
        SetMonthly(inData.nextDouble());
        System.out.print("Please enter the tax rate for " + super.GetName() + " in %: ");
        SetTax(inData.nextDouble());
        super.SetSalary(monthly - (monthly * (tax/100))); // Setting the salary of this individual employee
    }
}
