import java.util.Scanner;
class LinkedList<E> {
    // Intalizing the reference to the head and tail object
    private Node<E> head = null; 
    private Node<E> last = null;
    private int size = 0; // integer to store the size

    public int size() {
        return size;
    }

    public boolean isEmpty() { // Check if the list has any objects 
        return size == 1;
    }

    public Node<E> first() { // Function to get the first, returns null if empty
        return head;
    }

    public Node<E> last() { // Function to get the last node, returns null if empty
        return last;
    }

    public LinkedList() {} // Constructor to offset compiler errors

    private class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {return element;} // Function to get value
        public Node<E> next() {return next;} // Function to get reference to the next node
        public void setNext(Node<E> n) {next = n;} // Function to set the reference to the next node
    }

    public LinkedList addToList(LinkedList curList, E data) { // Function to add to a new number/character to a list
        Node<E> n = new Node(data, null); // Creating a new node with the sent data
        this.size++; // Increasing the size of the list
        if(this.isEmpty()) // If its the first entry, set the head to the new node
            curList.head = n;
        else // If not, set the current last's next node to the new one created
            curList.last().setNext(n); 
        curList.last = n; // Set the new last to the one created
        return curList; // Return the whole list
    }

    public void printList() { // Function to cycle through and print off the whole list
        Node<E> cur = head; // Reading in the head
        String nums = "", characters = "";
        while(cur != null) { // Cycle through until you reach the end
            String temp = String.valueOf(cur.getElement());
            if(Character.isDigit(temp.charAt(0)))
                nums+=temp;
            else
                characters+=temp;
            cur = cur.next(); // Get the reference to the currents next component
        }
        System.out.print(nums + characters);
    }
}