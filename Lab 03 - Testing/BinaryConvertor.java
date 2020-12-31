class BinaryConvertor {
    public static String NumberToBinary(int number) {
        String toReturn = ""; // 1 operation
        while(number > 0) { // log2(n) + 1, one additional operation after the final operation and n comes back as 0
            toReturn = number%2 + toReturn; // 3(log2(n)+1) operations
            number/=2; // 2(log2(n)+1) operations
        }
        return toReturn; // 1 operation
    }
}

// Primitive operations total is equal to: 1 + log2(n) + 1 + 3log2(n) + 3 + 2log2(n) + 2 + 1 = 8 + 6log2(n)
// The Big-Oh notation of this is log2(n), which is denotes log base 2 of n