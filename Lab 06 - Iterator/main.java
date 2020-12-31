class main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(); // Creating an array list
        System.out.println("------Part 1------");
        for(int i = 1; i <= 10; i++) // Cycling through 1 to 10 and adding it to the list
            arr.add(0, i);
        Iterator itr = arr.iterator(); // Creating an iterator
        while(itr.hasNext()) // Cycling through the whole array using iterator to print off each individual element 
            System.out.print(itr.next() + " ");
        System.out.println("\n");
        itr = arr.iterator(); // New iterator
        while(itr.hasNext()) // Cycling through till the end
        {
            itr.next(); // Go to next element
            itr.remove(); // Remove element

            Iterator itrPrint = arr.iterator(); // Create another iterator to print off remaining elements and indicies
            for(int i = 0; itrPrint.hasNext(); i++)
                System.out.print("Index " + i + " - Element " + itrPrint.next() + " | ");
            System.out.println("");
        }
        System.out.println("------Part 2------");
        for(int i = 10; i > 0; i--) // Cycling through and adding the numbers 10 to 1
            arr.add(0, i);
        itr = arr.iterator(); // Creating a new iterator
        for(int i = 0; itr.hasNext(); i++) // Cycling through an printing them all off
            System.out.print("Index " + i + " - Element " + itr.next() + " | ");
    }
}
