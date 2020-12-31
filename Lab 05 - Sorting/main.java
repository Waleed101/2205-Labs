class main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<Integer>(); // Creating the list
        for(int i = 190; i > -20; i--) // Making an array the goes from 1-10
            myList.addFirst(i);
        System.out.println(myList.doesExist(2)); // Checking to see if 2 is in the array (it is)
        System.out.println(myList.doesExist(120)); // Checking to see if 120 is in the array (it isn't)
        System.out.println(myList.doesExist(-15)); // Checking to see if -15 is in the array (it isn't)
    }
}

class DoublyLinkedList<E> {
    private Node<E> head, tail; // Reference to head and tail nodes
    private int size = 0;

    public E GetHead() {return head.next.GetValue();} // Function to get first value of list
    public E GetTail() {return tail.prev.GetValue();} // Function to get last value of list
    public boolean isEmpty() {return size==0;}
    public int GetSize() {return size;}

    DoublyLinkedList() { // Construcotr
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.SetNext(tail);
    }

    class Node<E> {
        private Node<E> prev, next; // Reference to previous and next node
        private E element;

        Node(Node<E> prev, Node<E> next, E element) { // Constructor for the node
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        public Node<E> GetPrev() {return this.prev;} // Function to get previous node
        public Node<E> GetNext() {return this.next;} // Function to get next node
        public void SetPrev(Node<E> newPrev) {this.prev = newPrev;} // Function to set previous node
        public void SetNext(Node<E> newNext) {this.next = newNext;} // Function to set next node
        public E GetValue() {return this.element;} // Function to get value of node
    }

    public void addFirst(E element) { // Function to add node to the beginning fo the list
        addBetween(element, this.head, this.head.GetNext());
    }

    public void addLast(E element) { // Function to add the node to the end of the list
        addBetween(element, this.tail.GetPrev(), this.tail);
    }

    private void addBetween(E element, Node<E> prev, Node<E> next) { // Function to add the node in between two nodes
        Node<E> newNode = new Node<>(prev, next, element);
        prev.SetNext(newNode);
        next.SetPrev(newNode);
        this.size++;
    }

    public boolean doesExist(E element) { // Base function to check if a node exisits
        return search(element, 0, this.GetSize());
    }

    private E GetSpecificInstance(int inst) { // Function to get a specific element, relative to its instance in the list
        Node<E> curNode = head;
        for(int i = 0; i <= inst; i++)
            curNode = curNode.GetNext();
        return curNode.GetValue();
    }

    private boolean search(E target, int low, int high) { // Binary search function
        if(low > high) // If the size is inverted, the element doesn't exisit
            return false;
        else {
            int middle = (low + high)/2; // Get the middle point
            E middleVal = GetSpecificInstance(middle); // Get the value at middle
            if(target == middleVal) // If its the same as the target, then it exists
                return true;
            else if(Integer.parseInt(target.toString()) < Integer.parseInt(middleVal.toString())) // Checking to see which end the value is in on the list
            // else if(target < middleVal)
                return search(target, low, middle-1); // Continuing the binary search on that portion of the list, if its on the left
            else
            {
                try { // Prevent a null pointer exception
                    return search(target, middle+1, high); // Continue the binary search on the right portion of the list
                }
                catch(NullPointerException e) { // If it gets here, that means that the value doesn't exist
                    return false;
                }
            }
        }
    } 
}