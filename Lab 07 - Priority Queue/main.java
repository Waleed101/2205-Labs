import java.util.Date; // Importing needed date functionality

class main {
    public static void main(String[] args) {
        SortedPriorityQueue<Long, String> normal = new SortedPriorityQueue<>(); // Creating an instance of the sorted priority key, with a key of type Long and a value of type String
        normal.insert(new Date().getTime(), "Alice"); // Inserting the sample records
        normal.insert((long)3, "Bob"); // Type casting to get type long, emergency will always be pushed to the top as the long value of date will never be that low
        normal.insert(new Date().getTime(), "Cat");
        normal.insert(new Date().getTime(), "Dan");
        normal.insert((long)1, "Eric");
        while(!normal.isEmpty()) // Iterate throught the whole list
            System.out.println(normal.removeMin().getValue()); // Remove and print each element in order
    }
}