class main {
    public static void main(String[] args) {
        System.out.println(IntegerToBinary(15)); // Test case for recursion function
    }

    public static String IntegerToBinary(int num) { // Recursive function to convert from integer to binary
        if(num > 0) // Recursive case
            return (IntegerToBinary(num/2) + (num%2)); // Operation 
        return ""; // Base case
    }
}