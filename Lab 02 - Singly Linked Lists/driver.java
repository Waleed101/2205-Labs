/*
    Created by: Waleed Sawan
    Created on: 2020-09-18
    Function: Reads in various numbers or characters until the user wants to finish (by indicating with the letter Y) and then 
    print off the list at the end.
*/


import java.util.Scanner;

class driver { 
    public static void main(String[] args) {
        LinkedList<Character> myList = new LinkedList<>(); // Creating a linked list
        Scanner inData = new Scanner(System.in); // Intializing the scanner
        do
        {
            System.out.print("Enter number or character: ");
            myList = myList.addToList(myList, inData.nextLine().charAt(0)); // Reading in user input as a char and adding to the list in one line
            System.out.print("Would you like to continue (Press 'Y' to continue)?: "); // Prompting them to see if they should continue
        } while(inData.nextLine().toUpperCase().charAt(0) == 'Y'); // If so, continue - if not exit (read in next line, make it uppercase and take the first letter)
        myList.printList(); // print off the list
    }
}