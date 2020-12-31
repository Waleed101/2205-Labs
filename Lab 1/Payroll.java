/*
    Created by: Waleed Sawan
    Created on: 2020-09-11
    Function: Read in three different types of employees (Part-time, Full-time, and manager) and their payroll information. The return is each
    individuals employees salary.
*/

import java.util.Scanner;

class Payroll {
    public static void main(String[] args) {
        int numOfEmployees = 0;
        Scanner inData = new Scanner(System.in);
        System.out.print("Welcome to Payroll Manager!\nPlease enter the number of employees: "); // Printing off initial statement to user
        numOfEmployees = inData.nextInt(); // Reading in the number of employees
        while(numOfEmployees < 3) // Ensure that its above the minimum
        {
            System.out.print("Uh oh! Please ensure that the number of employees is greater than or equal to 3: ");
            numOfEmployees = inData.nextInt();
        }
        Employee[] allEmployees = new Employee[numOfEmployees]; // Create an array based on the input
        for(int i = 0; i < numOfEmployees; i++) // Cycle through to get all inputs
        {
            int type = 0;
            System.out.println("---------------\nPlease enter a type:\n1 - Part-time Employee\n2 - Full-time Employee\n3 - Manager");
            type = inData.nextInt(); // Read in type of employee
            while(type < 1 || type > 3) // Ensure the type is within the bounds
            {
                System.out.print("Please ensure your type is within the options: ");
                type = inData.nextInt();
            }
            switch(type) // Initiate the correct type of employee
            {
                case 1: allEmployees[i] = new Parttime(); break;
                case 2: allEmployees[i] = new Fulltime(); break;
                case 3: allEmployees[i] = new Manager(); break;
            }
            allEmployees[i].CaptureBasicData(inData); // Capture the basic data to be read into by each user (name, address, phone number)
            allEmployees[i].CapturePaymentData(inData); // Capture each indvidual payment data
        }
        // Print out the final message with each employees' individual salary data and name
        System.out.println("\nThe following is all the payroll information for the entered employees. You entered information for " + numOfEmployees + " employees. ");
        for(int i = 0; i < numOfEmployees; i++)
            System.out.println(allEmployees[i].GetName() + " - $" + allEmployees[i].GetSalary());
    }
}