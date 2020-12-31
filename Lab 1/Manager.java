import java.util.Scanner;
public class Manager extends Fulltime { // Class for managers extends from Fulltime, which inherits from Employee
    // Custom variables
    private double bonus;

    Manager() { // Empty constructor
        super();
    }

    Manager(String sName, String sAddress, String sPhone) { // Constructor with main variables
        super(sName, sAddress, sPhone);
    }

    // Set function for custom variables
    public void SetBonus(double sBonus) {bonus = sBonus;}

    // Get function for custom variable
    public double GetBonus() {return bonus;}
    public int GetType() { return 3; } // 3 represents manager

    // Function to capture custom payment data
    public void CapturePaymentData(Scanner inData) {
        super.CapturePaymentData(inData);
        System.out.print("Please enter " + super.GetName() + "'s bonus: $");
        SetBonus(inData.nextDouble());
        // Setting the salary of this individual employee
        super.SetSalary(super.GetMonthly() - (super.GetMonthly() * (super.GetTax()/100)) + bonus);
    }
}