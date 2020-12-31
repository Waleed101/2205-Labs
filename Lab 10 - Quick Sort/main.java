class main {
    public static void main(String[] args) {
        LinkedQueue<Point<Integer>> list = new LinkedQueue<Point<Integer>>(); // Creating a linkedqueue with data type point (with inner data type Integer)
        PointComparator<Point<Integer>> comp = new PointComparator<Point<Integer>>(); // Creating a point comparator with data type Point (with inner data type Integer)
        populateQueue(list); // Populating the queue
        printQueue(list); // Printing out the queue
        populateQueue(list); // Repopulating the empty queue
        quickSort(list, comp); // Quick sorting the queue
        printQueue(list); // Printing it once again
    }

    public static <E> void populateQueue(LinkedQueue<Point<Integer>> S) { // Function to populate the queue with the default values
        S.enqueue(new Point(5,6));
        S.enqueue(new Point(7,10));
        S.enqueue(new Point(50,4));
        S.enqueue(new Point(7,3));
    }

    public static <E> void printQueue(LinkedQueue<Point<Integer>> S) { // Function to print off the queue
        while(S.size() > 1)
        {
            Point<Integer> p = S.dequeue();
            System.out.print("(" + p.getX() + ", " + p.getY() +"), ");
        }
        Point<Integer> p = S.dequeue();
        System.out.println("(" + p.getX() + ", " + p.getY() +")"); // Print it off without the comma at the end
    } 

    public static <E> void quickSort(LinkedQueue<Point<Integer>> S, PointComparator<Point<Integer>> comp) { // Quick sorting algorithim, as stated in the slides
        int n = S.size();
        if(n < 2) // The queue is just sorted based on what's already there
            return;
        Point<Integer> pivot = S.first(); // Lets take the first element as an arbitrary pivot, need to declare with Point<Integer> as a type to avoid errors
        LinkedQueue<Point<Integer>> L = new LinkedQueue<>(), E = new LinkedQueue<>(), G = new LinkedQueue<>(); // Need to include Point<Integer> as the definition to avoid a function not found error
        while(!S.isEmpty()) { // Divide original into L, E, and G
            Point<Integer> element = S.dequeue();
            int c = comp.compare(element, pivot);
            if(c < 0) // Element is less than the pivot
                L.enqueue(element);
            else if(c == 0) // Element is equal to the pivot
                E.enqueue(element);
            else // Element is greater than the pivot
                G.enqueue(element);
        }

        quickSort(L, comp); // Sort elements less than the pivot
        quickSort(G, comp); // Sort elements greater than the pivot

        // Combine all the results
        while(!L.isEmpty())
            S.enqueue(L.dequeue());
        while(!E.isEmpty())
            S.enqueue(E.dequeue());
        while(!G.isEmpty())
            S.enqueue(G.dequeue());
    }
}